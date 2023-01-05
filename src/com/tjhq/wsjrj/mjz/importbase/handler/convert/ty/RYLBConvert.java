package com.tjhq.wsjrj.mjz.importbase.handler.convert.ty;

import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.StringUtils;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;
import com.tjhq.wsjrj.mjz.importbase.utils.excel.TYDataUtil;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 10:07
 * \* Description: 人员类别转换器
 * \
 */
public class RYLBConvert {
    static YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");


    public static String convertToDbData(String value) {
        StringBuilder res = new StringBuilder();
        log.info("人员类别转换器,获取数据原始值:" + value);
        if (StringUtils.isNotEmpty(value)) {
            //原始值可以有多个 逗号隔开
            String[] splitZh = value.split("，");
            String[] splitEn = value.split(",");
            log.info("splitZh：" + Arrays.toString(splitZh) + " - length:" + splitZh.length);
            log.info("splitEn：" + Arrays.toString(splitEn) + " - length:" + splitEn.length);
            if (splitZh.length > 1) {
                for (int i = 0; i < splitZh.length; i++) {
                    //2.进行转换
                    String convertValue = String.valueOf(TYDataUtil.RYLB_MAP.get(splitZh[i]));
                    log.info("splitZh[i]：" + splitZh[i] + " -- convertValue：" + convertValue);
                    res.append(convertValue);
                    if (i != splitZh.length - 1) {
                        res.append(",");
                    }
                }
                log.info("转换为：" + res);
                return res.toString();
            }
            if (splitEn.length > 1) {
                for (int i = 0; i < splitEn.length; i++) {
                    //2.进行转换
                    String convertValue = String.valueOf(TYDataUtil.RYLB_MAP.get(splitEn[i]));
                    log.info("splitEn[i]：" + splitEn[i] + " -- convertValue：" + convertValue);
                    res.append(convertValue);
                    if (i != splitEn.length - 1) {
                        res.append(",");
                    }
                }
            } else {
                //没有逗号说明没有多选
                String convertRes = String.valueOf(TYDataUtil.RYLB_MAP.get(value));
                res.append(convertRes);
            }
            log.info("转换为：" + res);
            return res.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        String value = "甲状腺功能减退症,强直性脊柱炎，血友病";
        String[] splitZh = value.split("，");
        String[] splitEn = value.split(",");
        System.out.println("splitZh：" + Arrays.toString(splitZh) + "length:" + splitZh.length);
        System.out.println("splitEn：" + Arrays.toString(splitEn) + "length:" + splitEn.length);
        if (splitEn.length > 1) {
            System.out.println("进入循环");
            for (int i = 0; i < splitEn.length; i++) {
                //2.进行转换
                String convertValue = String.valueOf(TYDataUtil.RYLB_MAP.get(splitEn[i]));
                System.out.println("splitEn[i]：" + splitEn[i] + " -- convertValue：" + convertValue);
                res.append(convertValue);
                if (i != splitEn.length - 1) {
                    res.append(",");
                }
                System.out.println("res:" + res);
            }
        }
    }
}
