package cn.vincent.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    private final static SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat SDF_DATE_CUMU = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        System.out.println(getDateTimeStringListForSdjl("2020-05-01 23:58:59"));
    }
    public static List<String> getDateTimeStringListForSdjl(String maxSynedTv){
        List<String> result = new ArrayList<String>();
        result.add(maxSynedTv);
        try {
            // 开始 年-月-日
            Date startDate = SDF_DATE_CUMU.parse(maxSynedTv);
            // 今天 年-月-日
            String today = SDF_DATE_CUMU.format(new Date());
            Date endDate = SDF_DATE_CUMU.parse(today);
            // 放入日历
            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(startDate);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(endDate);
            // 循环
            while (endDate.after(calBegin.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                result.add(SDF_DATETIME.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
