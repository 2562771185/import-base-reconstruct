package com.tjhq.wsjrj.mjz.importbase.handler.convert.xczx;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.XczxDataUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/7
 * \* Time: 9:55
 * \* Description: 与户主关系转换器
 * \
 */
public class YhzgxConvert {

    public static String convertToDbData(String value) {
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");

        log.info("与户主关系转换器,获取数据原始值:" + value);
        //2.进行转换
        String convertValue = XczxDataUtil.YHZGX_MAP.get(value);
        log.info("转换为：" + convertValue);
        return StringUtils.isEmpty(convertValue) ? "0" : convertValue;
    }

}