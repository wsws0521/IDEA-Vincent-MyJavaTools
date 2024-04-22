package cn.vincent.date.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 类：Instant    时间戳
 * 类：Duration   持续时间，时间差
 * 类：LocalDate  日期，比如 2018-02-05
 * 类：LocalTime  时间，比如 23:12:10
 * 类：LocalDateTime  日期时间，比如 2018-02-05 23:12:10
 * 类：Period     时间段
 * 类：ZoneOffset 时区偏移量，比如： +8:00
 * 类：ZoneDateTime   带时区的日期时间
 * 类：Clock      时钟，比如获取目前美国纽约时间
 * 类：java.time.format.DateTimeFormatter 时间格式化
 */
public class UseJava8Time {
    public static void main(String[] args) {
        // 示例1:Java 8中获取今天的日期
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:" + today);
        // 示例2:Java 8中获取年、月、日信息
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("day:"+day);
        // 示例3:Java 8中创建特定日期（老API只能从1900开始，月份从0开始）
        LocalDate date = LocalDate.of(1800,2,6);
        System.out.println("自定义日期:"+date);
        // 示例4:Java 8中判断两个日期是否相等
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2020,2,16);
        if(date1.equals(date2)){
            System.out.println("日期相等");
        }else{
            System.out.println("日期不等");
        }
        // 示例5:Java 8中检查像生日这种【月日周期】事件
        MonthDay birthday = MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date1);
        if(currentMonthDay.equals(birthday)){
            System.out.println("是你的生日");
        }else{
            System.out.println("你的生日还没有到");
        }
        // 示例6:Java 8中获取当前时间（不含日期）
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期:"+time);
        // 示例7:Java 8中获取偏移当前时间
        LocalTime newTime = time.plusHours(3);
        System.out.println("三个小时后的时间为:"+newTime);
        // 示例8:Java 8如何计算一周后的日期
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:"+nextWeek);
        // 示例9:Java 8计算一年前或一年后的日期
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期 : " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期:"+nextYear);
        // 示例10:Java 8的Clock时钟类（时区+时间戳，以前用到System.currentTimeInMillis()和TimeZone.getDefault()的地方都可用Clock替换）
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());
        // 示例11:如何用Java判断日期是早于还是晚于另一个日期
        LocalDate tomorrow = LocalDate.of(2020,2,17);
        if(tomorrow.isAfter(today)){
            System.out.println("之后的日期:"+tomorrow);
        }
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("之前的日期:"+yesterday);
        }
        // 示例12:Java 8中处理时区（只是告诉你减几小时）（以前是GregorianCalendar类）
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america);
        System.out.println("当前日期时间 转换成纽约后的结果: " + dateAndTimeInNewYork);
        // 示例13:如何表示信用卡到期这类固定日期（YearMonth实例的lengthOfMonth()方法可以返回当月的天数，在判断2月有28天还是29天时非常有用）
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
        // 示例14:如何在Java 8中检查闰年
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
        // 示例15:计算两个日期之间的天数和月数
        LocalDate java8Release = LocalDate.of(2018, 12, 14);
        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );
        // 示例16:在Java 8中获取当前的时间戳
        Instant timestamp = Instant.now();
        System.out.println("当前时间戳=instant的值： " + timestamp.toEpochMilli());
        // 示例17:Java 8中如何使用预定义的格式化工具去解析或格式化日期
        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+"  格式化后的日期为:  "+formatted);
        // 示例18:字符串互转日期类型
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String str = dateTime.format(format1);
        System.out.println("日期转换为字符串:"+str);
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDate dateTime2 = LocalDate.parse(str,format2);
        System.out.println("字符串转日期类型:"+dateTime2);
    }

}
