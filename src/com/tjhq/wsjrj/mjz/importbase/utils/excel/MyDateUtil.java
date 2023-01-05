package com.tjhq.wsjrj.mjz.importbase.utils.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: mjz
 * \* Date: 2022/12/22
 * \* Time: 16:58
 * \* Description:
 * \
 */
public class MyDateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String formatDate(String dateStr,String format) {
        if (dateStr == null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = new Date();
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(format).format(date);
    }
}
