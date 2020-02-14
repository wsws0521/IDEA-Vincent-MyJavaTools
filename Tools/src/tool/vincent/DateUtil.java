package tool.vincent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfDateCumu = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        List<String> dates = getDuringDateStr("2020-02-12 23:56:58");
        System.out.println(dates);

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
            Date startDate = sdfDateCumu.parse(maxVendDateStr);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, -1);
            String yesterdayStr = sdfDateCumu.format(calendar.getTime());
            Date endDate = sdfDateCumu.parse(yesterdayStr);

            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(startDate);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(endDate);
            while (endDate.after(calBegin.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                result.add(sdfDateCumu.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getShortDateFromString(String dateTimeStr) {
        Date inputDate = null;
        try {
            inputDate = sdfDateCumu.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdfDate.format(inputDate);
    }
}
