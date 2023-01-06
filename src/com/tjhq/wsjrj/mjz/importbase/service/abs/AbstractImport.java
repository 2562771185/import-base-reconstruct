package com.tjhq.wsjrj.mjz.importbase.service.abs;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hw.fb.form.adapter.sql.service.IFormSqlService;
import com.tjhq.hqoa.framework.framework.Result;
import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.cl.CJDJConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.cl.CJLBConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.cl.CZZTConvert;
import com.tjhq.wsjrj.mjz.importbase.handler.convert.common.SSYFConvert;
import com.tjhq.wsjrj.mjz.importbase.model.dto.ImportExcelDto;
import com.tjhq.wsjrj.mjz.importbase.model.entity.BaseEntity;
import com.tjhq.wsjrj.mjz.importbase.model.entity.PersonCL;
import com.tjhq.wsjrj.mjz.importbase.model.vo.CLExcelVo;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.BeanUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.MyExcelUtils;
import lombok.SneakyThrows;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2023/1/4
 * \* Time: 10:11
 * \* Description: 抽象导入类，子类实现抽象方法进行导入
 * \
 */
public abstract class AbstractImport {
    YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");
    @Autowired
    private IFormSqlService sqlService;

    @Transactional(rollbackFor = Exception.class)
    public Result<?> importExcel(ImportExcelDto excelDto, Class<?> entityClass, Class<?> voClass) {
        //返回给前端的日志字符串
        StringBuilder logStr = new StringBuilder();
        //解析Excel
        List<?> vos = parseExcel(excelDto.getExcel(), voClass);
        //过滤、转化数据
        List<?> entityList = filterAndConvertData(vos);
        log.info("过虑、转化之后的合法数据entityList:" + JSON.toJSONString(entityList));
        log.info("entityList.size():" + entityList.size());
        //保存数据入库
        int successCount = saveData(entityList, logStr, log, sqlService, entityClass);
        logStr.append("--------------------------------" + "表中总数据:[")
                .append(vos.size())
                .append("] , 合法数据记录数:[")
                .append(entityList.size())
                .append("] , 追加成功数: ")
                .append(successCount)
                .append("--------------------------------");
        if (excelDto.getPrintlog()) {
            printLog(logStr);
        }
        if (successCount == vos.size()) {
            return Result.OK("成功追加:[" + successCount + "]条记录", logStr);
        }
        Result<String> failRes = new Result<>();
        failRes.setCode(500);
        failRes.setMsg("导入失败:【总记录数:[" + vos.size() + "],合法数据条数:[" + entityList.size() + "],仅成功:[" + successCount + "]条数据】");
        failRes.setResult(logStr.toString());
        return failRes;
    }


    private int saveData(List<?> entityList, StringBuilder logStr, YCLogUtil log, IFormSqlService sqlService, Class<?> entityClass) {
        //生成过滤map
        MultiMap filterMap = createFilterMap(entityClass);
        log.info("filterMap:" + filterMap);
        log.info("filterMap.size():" + filterMap.size());
        return verifyData(entityList, filterMap, logStr, log, sqlService);
    }

    @SneakyThrows
    private int verifyData(List<?> entityList, MultiMap sfzhMap, StringBuilder logStr, YCLogUtil log, IFormSqlService sqlService) {
        int successCount = 0;
        //存储一定量sql语句再一起执行
        ArrayList<String> sqlList = new ArrayList<>(SysConstant.BATCH_COUNT);
        for (int i = 0; i < entityList.size(); i++) {
            //判断是否能添加标志
            int flag = 1;
            BaseEntity entity = (BaseEntity) entityList.get(i);
            log.info(i + " - 转化为具体数据：" + entity);
            //判断验证重复条件 -身份证 and 所属年份 and 所属月份 全部重复才不能添加
            boolean verifyIdCard = sfzhMap.containsKey(entity.getSfzh());
            log.info("身份证是否重复：" + verifyIdCard);
            //判断身份证是否重复
            if (verifyIdCard) {
                List<BaseEntity> sfzList = (List<BaseEntity>) sfzhMap.get(entity.getSfzh());
                log.info("身份证重复数据列表:" + JSON.toJSONString(sfzList));
                log.info("sfzList.size():" + sfzList.size());
                for (BaseEntity nfYfVo : sfzList) {
                    boolean verifySznf = entity.getSznf().equals(nfYfVo.getSznf());
                    boolean verifySzyf = entity.getSzyf().equals(nfYfVo.getSzyf());
                    log.info(String.format("所属年份是否重复：%s,所属月份是否重复：%s", verifySznf, verifySzyf));
                    //如果年份月份也重复则不能添加
                    if (verifySznf && verifySzyf) {
                        flag = 0;
                        generateFailLogString(logStr, entity, i);
                        break;
                    }
                }
            }
            if (flag != 0) {
                log.info(i + " - 满足入库条件：" + entity);
                sqlList.add(buildSqlString(entity));
                if (sqlList.size() >= SysConstant.BATCH_COUNT) {
                    log.info("执行了一次批量入库:" + JSON.toJSONString(sqlList));
                    sqlService.executeBatchSql("master", sqlList);
                    sqlList.clear();
                }
                generateSuccessLogString(logStr, entity);
                successCount++;
                //把添加成功的信息添加到过滤列表中
                sfzhMap.put(entity.getSfzh(), entity);
            }
        }
        //入库剩余的数据
        log.info("入库剩余的数据数量:" + sqlList.size());
        log.info("入库剩余的数据:" + JSON.toJSONString(sqlList));
        sqlService.executeBatchSql("master", sqlList);
        return successCount;
    }


    private List<?> parseExcel(MultipartFile excel, Class<?> voClass) {
        List<?> vos = MyExcelUtils.readExcel(voClass, excel);
        log.info("读取到的数据：" + JSON.toJSONString(vos));
        if (CollectionUtils.isEmpty(vos) || vos.size() < 1) {
            log.info("解析数据失败，无数据:" + excel.getOriginalFilename());
            throw new RuntimeException("解析excel数据失败，无数据!");
        }
        return vos;
    }

    /**
     * 需要子类根据自己的情况过滤、转化数据
     *
     * @param vos 传入excel读取到的数据list
     */
    protected abstract List<?> filterAndConvertData(List<?> vos);

    /**
     * 生成过滤map
     *
     * @return 身份证号为key，多个entity为value的map
     */
    private MultiMap createFilterMap(Class<?> clz) {
        IService<BaseEntity> service = (IService<BaseEntity>) BeanUtils.getBean(clz.getSimpleName() + "Service");
        log.info("service = " + service);
        List<BaseEntity> list = service.list();
        log.info("list = " + JSON.toJSONString(list));
        MultiMap sfzhMap = new MultiValueMap();
        for (BaseEntity cl : list) {
            sfzhMap.put(cl.getSfzh(), cl);
        }
        sfzhMap.put(null, null);
        return sfzhMap;
    }

    /**
     * 输出日志到文件中
     */
    protected abstract void printLog(StringBuilder logStr);

    protected abstract String buildSqlString(BaseEntity entity);

    private void generateSuccessLogString(StringBuilder logStr, BaseEntity entity) {
        logStr.append(DateTime.now()).append(" - 追加成功-条件通过:\n")
                .append(" - 姓名:[").append(entity.getXm())
                .append("]- 身份证号：[").append(entity.getSfzh())
                .append("] - 所属年份：[").append(entity.getSznf()).append("] - 所属月份：[")
                .append(Integer.parseInt(entity.getSzyf()) + 1).append("]-【成功】 \n");
    }

    private void generateFailLogString(StringBuilder logStr, BaseEntity entity, int i) {
        logStr.append(DateTime.now()).append(" - 追加失败-条件不通过:\n").append(" <身份证>重复")
                .append(" <所属年份>重复 ").append(" <所属月份>重复 ")
                .append(" - 姓名:[").append(entity.getXm())
                .append("]- 身份证号：[").append(entity.getSfzh())
                .append("] - 所属年份：[").append(entity.getSznf())
                .append("] - 所属月份：[").append(Integer.parseInt(entity.getSzyf()) + 1)
                .append("]-【失败】 第").append(i + 1).append("行\n");
    }
}
