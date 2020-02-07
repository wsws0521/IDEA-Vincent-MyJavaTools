package com.vincent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfDateCumu = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        System.out.println(getDateFromString("2020-02-06 19:30:17"));
    }
    public static String getSysDateYestoday(){
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.add(calendar.DATE, -1);
        return sdfDate.format(calendar.getTime());
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
