package com.tjhq.wsjrj.mjz.importbase.handler.convert.mbkbz;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.CommonDataUtil;

import java.util.Arrays;


/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/9
 * \* Time: 10:07
 * \* Description: 慢病卡病种
 * \
 */
public class MbkbzConvert{
    static YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");


    public static String convertToDbData(String value){
        StringBuilder res = new StringBuilder();
        log.info("慢病卡病种转换器,获取数据原始值:" + value);
        if (StringUtils.isNotEmpty(value)) {
            //原始值可以有多个 逗号隔开
            String[] splitZh = value.split("，");
            String[] splitEn = value.split(",");
            log.info("splitZh：" + Arrays.toString(splitZh) + " - length:" + splitZh.length);
            log.info("splitEn：" + Arrays.toString(splitEn) + " - length:" + splitEn.length);

            if (splitEn.length > 1) {
                for (int i = 0; i < splitEn.length; i++) {
                    //2.进行转换
                    String convertValue = String.valueOf(CommonDataUtil.MBKBZ_MAP.get(splitEn[i]));
                    log.info("splitEn[i]：" + splitEn[i] + " -- convertValue：" + convertValue);
                    res.append(convertValue);
                    if (i != splitEn.length - 1) {
                        res.append(",");
                    }
                }
                log.info("res:" + res);
                return res.toString();
            }
            if (splitZh.length > 1) {
                for (int i = 0; i < splitZh.length; i++) {
                    //2.进行转换
                    String convertValue = String.valueOf(CommonDataUtil.MBKBZ_MAP.get(splitZh[i]));
                    log.info("splitZh[i]：" + splitZh[i] + " -- convertValue：" + convertValue);
                    res.append(convertValue);
                    if (i != splitZh.length - 1) {
                        res.append(",");
                    }
                }
            } else {
                //没有逗号说明没有多选
                String convertRes = String.valueOf(CommonDataUtil.MBKBZ_MAP.get(value));
                res.append(convertRes);
            }
            log.info("转换为：" + res);
            return res.toString();
        }
        return "";
    }
}