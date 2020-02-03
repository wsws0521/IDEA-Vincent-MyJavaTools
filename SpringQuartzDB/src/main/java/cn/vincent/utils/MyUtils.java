package cn.vincent.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
    private static SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    public static String getSysDateTime(){
        return sdfDateTime.format(new Date());
    }
    public static String getSysDate(){
        return sdfDate.format(new Date());
    }
}
