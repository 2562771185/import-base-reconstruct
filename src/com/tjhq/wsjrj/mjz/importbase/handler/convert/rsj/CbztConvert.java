package com.tjhq.wsjrj.mjz.importbase.handler.convert.rsj;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.RsjnDataUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/7
 * \* Time: 15:30
 * \* Description: 参保状态转换器
 * \
 */
public class CbztConvert {

    public static String convertToDbData(String value) {
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");

        log.info("参保状态转换器,获取数据原始值:" + value);
        //2.进行转换
        String convertValue = RsjnDataUtil.CBZT_MAP.get(value);
        log.info("转换为：" + convertValue);
        return StringUtils.isEmpty(convertValue) ? "0" : convertValue;
    }

}
