package com.tjhq.wsjrj.mjz.importbase.utils.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/7
 * \* Time: 10:43
 * \* Description: 人社局数据字典
 * \
 */
public class RsjnDataUtil {
    /**
     * 参保状态
     */
    public static final Map<String, String> CBZT_MAP = new HashMap<>();

    static {
        CBZT_MAP.put("正常参保", "0");
        CBZT_MAP.put("终止参保", "1");
    }
}
