package cn.vincent.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDateUtils {
    private final static SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfDateCumu = new SimpleDateFormat("yyyy-MM-dd");


    public static String getSysDateTime(){
        return sdfDateTime.format(new Date());
    }
    public static String getSysDate(){
        return sdfDate.format(new Date());
    }
    public static String getSysDateYestoday(){
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.add(calendar.DATE, -1);
        return sdfDateCumu.format(calendar.getTime());
    }
    public static String getDateFromString(String dateTimeStr) {
        Date inputDate = null;
        try {
            inputDate = sdfDateCumu.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdfDateCumu.format(inputDate);
    }
}
