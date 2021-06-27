package tool.vincent.algorithm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HouseLoan {
    // 保留两位小数
    private static DecimalFormat df_two = new DecimalFormat("#0.00");
    // 保留6位小数
    private static DecimalFormat df_four = new DecimalFormat("#0.000000");

    public static void main(String[] args) {

        System.out.println(matchingRepayment(1000000, 0.03575, 13));
        System.out.println(matchingService(1000000, 0.03575, 13));
    }

    /**
     * 等额本金
     * 将本金分摊到每个月，每月还款仅对剩余【本金】计息
     * @param borrowSum 借款总额 100W
     * @param yearRate  年利率   3.575%
     * @param years     借款年限 13
     * @return
     */
    private static Map<String, Double> matchingRepayment(double borrowSum, double yearRate, int years){
        int months = years * 12;
        Map<String, Double> result = new LinkedHashMap<>();
        // 月本金
        double monthBase = Double.valueOf(df_two.format(borrowSum / months));
        // 月利率
        double monthRate = Double.valueOf(df_four.format(yearRate / 12));
        for (int i = 1; i < months + 1; i++) {
            // 对剩余本金计算月息
            double monthService = (months - i + 1) * monthBase * monthRate;
            double monthSum = monthBase + monthService;
            result.put("第" + i + "月", monthSum);
        }
        return result;
    }

    /**
     * 等额本息   先计算出利息总额，再除以月数
     * @param borrowSum
     * @param yearRate
     * @param years
     * @return
     */
    private static double matchingService(double borrowSum, double yearRate, int years){
        // 月数
        int months = years * 12;
        // 月利率
        double monthRate = Double.valueOf(df_four.format(yearRate / 12));
        // 总利率
        double multiRate = Double.valueOf(df_two.format(Math.pow(1 + monthRate, months)));
        // 每月还款 = 【本金 * 月利率 * 总利率】 / 【总利率 - 1】
        double resultTotle = borrowSum * monthRate * multiRate;
        double result = resultTotle / (multiRate - 1);
        return result;
    }
}
