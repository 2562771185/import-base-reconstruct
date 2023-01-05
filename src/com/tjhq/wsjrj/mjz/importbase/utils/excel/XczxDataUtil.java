package com.tjhq.wsjrj.mjz.importbase.utils.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/6
 * \* Time: 16:32
 * \* Description: 乡村振兴数据
 * \
 */
public class XczxDataUtil {
    /**
     * 户类型列表
     */
    public static final Map<String, String> HLX_MAP = new HashMap<>();
    /**
     * 监测对象类型
     */
    public static final Map<String, String> JCDXLX_MAP = new HashMap<>();

    /**
     * 与户主关系
     */
    public static final Map<String, String> YHZGX_MAP = new HashMap<>();

    static {
        HLX_MAP.put("普通农户", "0");
        HLX_MAP.put("脱贫户", "1");

        JCDXLX_MAP.put("脱贫不稳定户", "0");
        JCDXLX_MAP.put("边缘易致贫户", "1");
        JCDXLX_MAP.put("突发严重困难户", "2");

        YHZGX_MAP.put("户主", "0");
        YHZGX_MAP.put("配偶", "1");
        YHZGX_MAP.put("其他", "2");
        YHZGX_MAP.put("之曾孙女", "3");
        YHZGX_MAP.put("之曾孙子", "4");
        YHZGX_MAP.put("之儿媳", "5");
        YHZGX_MAP.put("之父", "6");
        YHZGX_MAP.put("之公公", "7");
        YHZGX_MAP.put("之母", "8");
        YHZGX_MAP.put("之女", "9");
    }
}
