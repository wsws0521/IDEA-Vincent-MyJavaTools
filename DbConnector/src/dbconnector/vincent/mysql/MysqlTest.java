package dbconnector.vincent.mysql;

import dbconnector.vincent.mysql.dao.MysqlDao;

import java.util.List;

public class MysqlTest {
    public static void main(String[] args) {
        int num = 0;
        MysqlDao dao = new MysqlDao();
        List<String> meterNos = dao.getAll();
        System.out.println(meterNos.size());

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String meterNo : meterNos ) {
            if(!check(meterNo)){
                sb.append("'");
                sb.append(meterNo);
                sb.append("'");
                sb.append(",");
                num ++;
            }
        }
        sb.append(")");

        System.out.println(num);
        System.out.println(sb.toString());
    }




    public static boolean check(String meterNo)
    {
        int sum = 0;
        boolean isDouble = meterNo.length() % 2 == 0;
        for (int i = 0; i < meterNo.length() - 1; ++i) {
            int point = meterNo.charAt(i) - '0';
            if (((isDouble) && (i % 2 == 0)) || ((!(isDouble)) && (i % 2 == 1)))
                point *= 2;

            if (point > 9) {
                sum += point / 10;
                sum += point % 10;
            } else {
                sum += point;
            }
        }

        int endPoint = (Math.abs(sum % 10 - 10) == 10) ? 0 : Math.abs(sum % 10 - 10);

        int endPointAct = meterNo.charAt(meterNo.length() - 1) - '0';
        return (endPoint == endPointAct);
    }
}
