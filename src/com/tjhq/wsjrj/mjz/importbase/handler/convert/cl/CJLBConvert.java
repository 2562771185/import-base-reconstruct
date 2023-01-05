package com.tjhq.wsjrj.mjz.importbase.handler.convert.cl;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.CLDataUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/11/24
 * \* Time: 16:24
 * \* Description: 残疾类别转换器  0-视力 1-听力  2-言语 3-智力 4-肢体 5-精神 6-多重
 * \
 */
public class CJLBConvert {

    public static String convertToDbData(String value) {
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");
        log.info("进入残疾类别转换器,获取数据原始值:" + value);
        //2.进行转换
        String convertValue = CLDataUtil.CJLB_MAP.get(value);
        log.info("转换为：" + convertValue);
        return StringUtils.isEmpty(convertValue) ? "0" : convertValue;

    }
}
