package com.app.secret.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String DATE_FORMAT_DATE = "yyyy-MM-dd";

    private static final String DATE_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_FORMAT_TIME = "HH:mm:ss";

    public static String getCurrentDate(){
        return getCurrentDate(DATE_FORMAT_DATE);
    }

    private static String getCurrentDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getCurrentDatetime(){
        return getCurrentDatetime(DATE_FORMAT_DATE_TIME);
    }

    private static String getCurrentDatetime(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getCurrentTime(){
        return getCurrentTime(DATE_FORMAT_TIME);
    }

    private static String getCurrentTime(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String foramtDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
