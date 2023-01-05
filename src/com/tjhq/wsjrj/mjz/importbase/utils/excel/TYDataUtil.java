package com.tjhq.wsjrj.mjz.importbase.utils.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 16:32
 * \* Description:
 * \
 */
public class TYDataUtil {
    /**
     * 人员类别列表
     */
    public static final Map<String, String> RYLB_MAP = new HashMap<>();
    /**
     * 对象状态
     */
    public static final Map<String, String> DXZT_MAP = new HashMap<>();

    static {
        RYLB_MAP.put("退役士兵", "0");
        RYLB_MAP.put("军队转业干部", "1");
        RYLB_MAP.put("残疾军人", "2");
        RYLB_MAP.put("军队离退休干部和退休士官", "3");
        RYLB_MAP.put("无军籍离退休退职职工", "4");
        RYLB_MAP.put("复员军人", "5");
        RYLB_MAP.put("伤残民兵民工", "6");
        RYLB_MAP.put("烈士遗属", "7");
        RYLB_MAP.put("因公牺牲军人遗属", "8");
        RYLB_MAP.put("病故军人遗属", "9");

        DXZT_MAP.put("享受抚恤补助", "0");
    }
}
