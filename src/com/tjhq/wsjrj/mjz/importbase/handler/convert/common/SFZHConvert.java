package com.tjhq.wsjrj.mjz.importbase.handler.convert.common;

import cn.hutool.core.util.IdcardUtil;
import com.tjhq.wsjrj.mjz.importbase.constants.SysConstant;
import com.tjhq.wsjrj.mjz.importbase.utils.YCLogUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 10:07
 * \* Description: 身份证号码验证
 * \
 */
public class SFZHConvert{

    public static String convertToDbData(String value){
        YCLogUtil log = YCLogUtil.log(SysConstant.SYSTEM_LOG_NAME, "mjz");
        log.info("身份证号码验证,获取数据原始值:"+value);
        if (IdcardUtil.isValidCard(value)) {
            //正确直接返回
            return value;
        }
        //不正确 返回空
        return "";

    }

}
