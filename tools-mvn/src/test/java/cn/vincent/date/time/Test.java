package cn.vincent.date.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
//        LocalTime threeDaysAgo = LocalTime.now().minusHours(24 * 3);
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.minusDays(3));

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String str = dt.format(format1);
        System.out.println(str);
    }
}
