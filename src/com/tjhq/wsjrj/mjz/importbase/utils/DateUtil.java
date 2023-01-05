package com.tjhq.wsjrj.mjz.importbase.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 时间相加
     * @param createTime
     * @param blsx
     * @return
     */
    public static String getYqwcsj(String createTime,String blsx) {
        int blsxInt = Integer.parseInt(blsx);
        //String转Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, blsxInt);
        date = ca.getTime();
        String enddate = format.format(date);
        return enddate;
    }

    /**
     *格式化时间 传入String
     * @param date
     * @param formatString
     * @return
     */
    public static String formatData(String date,String formatString){
        if(StringUtils.isEmpty(date)){
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        String formatDate = "";
        try {
            formatDate = format.format(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    /**
     *格式化当前时间 传入String
     * @param formatString
     * @return
     */
    public static String formatData(String formatString){
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        return format.format(new Date());
    }
}
