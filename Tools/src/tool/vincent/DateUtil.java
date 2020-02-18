package tool.vincent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat SDF_DATE_CUMU = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        List<String> datesOpen = getDuringDateStr("2020-02-17");
        System.out.println(datesOpen);
        List<String> datesClose = getDuringDateStrListClose("2020-02-17");
        System.out.println(datesClose);

        System.out.println(getShortDateFromString("2020-02-07 16:52:18"));
//        System.out.println(getDateFromString("2020-02-06 19:30:17"));
    }
//    public static String getSysDateYestoday(){
//        Date now = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(now);
//        calendar.add(calendar.DATE, -1);
//        return sdfDate.format(calendar.getTime());
//    }
//    public static String getDateFromString(String dateTimeStr) {
//        Date inputDate = null;
//        try {
//            inputDate = sdfDateCumu.parse(dateTimeStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return sdfDateCumu.format(inputDate);
//    }
    public static List<String> getDuringDateStr(String maxVendDateStr) {
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
            inputDate = SDF_DATE_CUMU.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdfDate.format(inputDate);
    }
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
}
