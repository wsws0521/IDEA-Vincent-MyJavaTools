package tool.vincent.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        Map<String, Object> importResult = new HashMap<>();
        importResult.put("errorCode", "00");
//        importResult.put("sdcssx", "2000000000");
        importResult.put("sdcssx", "2000000000");
        importResult.put("expirationDate", "20210719220000");
//        int num = (int) importResult.get("sdcssx");
        int num = Integer.parseInt(importResult.get("sdcssx").toString());

        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            date = sdf.parse(importResult.get("expirationDate").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(num);
        System.out.println(date);
    }

}
