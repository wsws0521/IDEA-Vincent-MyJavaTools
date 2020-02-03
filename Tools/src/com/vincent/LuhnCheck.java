package com.vincent;

public class LuhnCheck {

    public static void main(String[] args) {
//        String meterNo = "07055025361";
        String meterNo = "14326600717";
        System.out.println(check(meterNo));
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
