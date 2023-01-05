package com.tjhq.wsjrj.mjz.importbase.aspect;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjhq.wsjrj.mjz.importbase.annotation.LogAnnotation;
import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.IpUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.HttpContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

/**
 * 日志切面
 */
@Aspect //切面 定义了通知和切点的关系
@Component
public class LogAspect {
    @Autowired
    private ObjectMapper objectMapper;

    YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");

    @Pointcut("@annotation(com.tjhq.wsjrj.mjz.importbase.annotation.LogAnnotation)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        recordLog(point, time);
        return result;
    }

    private void recordLog(ProceedingJoinPoint joinPoint, long time) throws JsonProcessingException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("================================ log start ================================");
        log.info(String.format("module:{%s},operation:{%s}", logAnnotation.module(), logAnnotation.operation()));
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info(String.format("request method:{%s}", className + "." + methodName + "()"));
        String[] parameterNames = signature.getParameterNames();
        //请求的参数
        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            log.info(String.format("params:{%s}", "null"));
        } else {
            log.info("request params:");
            log.info("-------------------");
            for (int i = 0; i < args.length; i++) {
                if (!isFilterObject(args[i])) {
                    log.info(String.format("%s: %s", parameterNames[i], JSON.toJSONString(args[i])));
                }
            }
            log.info("-------------------");
        }
        //获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info(String.format("ip: %s", IpUtils.getIpAddr(request)));
        log.info(String.format("execute time : {%s} ms", time));
        log.info("================================ log end ================================");
    }

    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            //如果是数组-》判断数组类型是不是MultipartFile，是的话则过滤掉
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        }
        //如果是集合类型，则进行遍历
        else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        //以上操作都是为了过滤掉MultipartFile，此对象在转化为json好像会报错？ 因为json无法解析MultipartFile
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
        // 过滤掉这些json无法解析或者无需字符串化的class
    }
}