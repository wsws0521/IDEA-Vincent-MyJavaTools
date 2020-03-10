package cn.vincent.utils;

import org.springframework.util.StringUtils;

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
    public static String getSysDateShort(){
        return SDF_DATE_SHORT.format(new Date());
    }
    public static String getSysDateCumu(){
        return SDF_DATE_CUMU.format(new Date());
    }
    public static String getSysDateYesterday(){
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.add(calendar.DATE, -1);
        return SDF_DATE_CUMU.format(calendar.getTime());
    }
//    public static Date getStartDate(String inputStartDateStr){
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, 0);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        try {
//            Date monthFirst = SDF_DATE_CUMU.parse(SDF_DATE_CUMU.format(calendar.getTime()));
//            Date inputStartDate = SDF_DATE_CUMU.parse(inputStartDateStr);
//            if(inputStartDate.after(monthFirst)){
//                return inputStartDate;
//            }else{
//                return monthFirst;
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 获取指定日期与当前日期中间的日期字符串，开区间（每天只自动同步一次累计值的情况）
     * @param maxVendDateStr    tmp_ljz1表中的日期字符串，yyyy-MM-dd
     * @return
     */
    public static List<String> getDuringDateStrListOpen(String maxVendDateStr){
        List<String> result = new ArrayList<String>();
        if(StringUtils.isEmpty(maxVendDateStr))
            return result;
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
    /**
     * 获取指定日期与当前日期中间的日期字符串，闭区间（多次手动同步当日累计值的情况）
     * @param maxVendDateStr    tmp_ljz1表中的日期字符串
     * @return
     */
    public static List<String> getDuringDateStrListClose(String maxVendDateStr){
        List<String> result = new ArrayList<String>();
        try {
            Date startDate = SDF_DATE_CUMU.parse(maxVendDateStr);
            result.add(SDF_DATE_CUMU.format(startDate));
            // 截止日期去除时分秒，只保留年月日
            String today = SDF_DATE_CUMU.format(new Date());
            Date endDate = SDF_DATE_CUMU.parse(today);

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
