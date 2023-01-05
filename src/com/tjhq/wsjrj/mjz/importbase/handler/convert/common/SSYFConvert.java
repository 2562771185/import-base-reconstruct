package com.tjhq.wsjrj.mjz.importbase.handler.convert.common;


import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.CommonDataUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 10:07
 * \* Description: 所属月份转换器
 * \
 */
public class SSYFConvert {
    public static String convertToDbData(String value) {
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");
        log.info("所属月份转换器,获取数据原始值:"+value);
        //进行转换
        String convertValue = CommonDataUtil.MONTH_MAP.get(value);
        log.info("转换为："+convertValue);
        return StringUtils.isEmpty(convertValue) ? "0" : convertValue;
    }

}
