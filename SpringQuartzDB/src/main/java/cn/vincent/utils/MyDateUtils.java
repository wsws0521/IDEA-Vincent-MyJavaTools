package cn.vincent.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyDateUtils {
    private final static SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final static SimpleDateFormat SDF_DATE_SHORT = new SimpleDateFormat("yyyyMMdd"); // 这种格式parse基本都是错误的，慎用
    private final static SimpleDateFormat SDF_DATE_CUMU = new SimpleDateFormat("yyyy-MM-dd");


    public static String getSysDateTime(){
        return SDF_DATETIME.format(new Date());
    }
    public static String getSysDate(){
        return SDF_DATE_SHORT.format(new Date());
    }
    public static String getSysDateYesterday(){
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.add(calendar.DATE, -1);
        return SDF_DATE_CUMU.format(calendar.getTime());
    }
    public static List<String> getDuringDateStrList(String maxVendDateStr){
        List<String> result = new ArrayList<String>();
        try {
            Date startDate = SDF_DATE_CUMU.parse(maxVendDateStr);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, -1);
            String yesterdayStr = SDF_DATE_CUMU.format(calendar.getTime());
            Date endDate = SDF_DATE_CUMU.parse(yesterdayStr);

            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(startDate);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(endDate);
            while (endDate.after(calBegin.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                result.add(SDF_DATE_CUMU.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getShortDateFromString(String dateTimeStr) {
        Date inputDate = null;
        try {
            // 用yyyyMMdd去parse，会出错...必须用yyyy-MM-dd
            inputDate = SDF_DATE_CUMU.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return SDF_DATE_SHORT.format(inputDate);
    }
}
