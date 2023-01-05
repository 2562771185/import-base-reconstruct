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
public class CLDataUtil {
    /**
     * 残疾类别列表
     */
    public static final Map<String, String> CJLB_MAP = new HashMap<>();
    /**
     * 持证状态
     */
    public static final Map<String, String> CZZT_MAP = new HashMap<>();
    /**
     * 残疾等级
     */
    public static final Map<String, String> CJDJ_MAP = new HashMap<>();


    static {
        CJLB_MAP.put("视力", "0");
        CJLB_MAP.put("听力", "1");
        CJLB_MAP.put("言语", "2");
        CJLB_MAP.put("智力", "3");
        CJLB_MAP.put("肢体", "4");
        CJLB_MAP.put("精神", "5");
        CJLB_MAP.put("多重", "6");

        CZZT_MAP.put("持证", "0");
        CZZT_MAP.put("注销", "1");
        CZZT_MAP.put("过期", "2");
        CZZT_MAP.put("冻结", "3");

        CJDJ_MAP.put("一级", "0");
        CJDJ_MAP.put("二级", "1");
        CJDJ_MAP.put("三级", "2");
        CJDJ_MAP.put("四级", "3");

    }

}
