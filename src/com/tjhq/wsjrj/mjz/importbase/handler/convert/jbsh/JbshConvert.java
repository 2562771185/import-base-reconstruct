package com.tjhq.wsjrj.mjz.importbase.handler.convert.jbsh;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.CommonDataUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 10:07
 * \* Description: 基本生活保障类型转换器
 * \
 */
public class JbshConvert {


    public static String convertToDbData(String value) {
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");
        log.info("基本生活保障类型转换器,获取数据原始值:" + value);
        //2.进行转换
        String convertValue = CommonDataUtil.JBSH_MAP.get(value);
        log.info("转换为：" + convertValue);
        return StringUtils.isEmpty(convertValue) ? "0" : convertValue;
    }

}
