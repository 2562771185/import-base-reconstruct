package com.tjhq.wsjrj.mjz.importbase.handler.convert.common;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.CommonDataUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/12
 * \* Time: 9:42
 * \* Description: 数据来源
 * \
 */
public class SJLYConvert{
    public static String convertToDbData(String value){
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");
        log.info("数据来源转换器,获取数据原始值:"+value);
        //2.进行转换
        String convertValue = CommonDataUtil.SSLY_MAP.get(value);
        log.info("转换为："+convertValue);
        return StringUtils.isEmpty(convertValue) ? "0" : convertValue;
    }

}
