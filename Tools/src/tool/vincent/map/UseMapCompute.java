package tool.vincent.map;

import java.util.HashMap;

/**
 * 思考：需要统计一个字符串中各个字符出现的次数
 */
public class UseMapCompute {
    public static void main(String[] args) {
        String str = "hello java, i am vary happy! nice to meet you";
        // jdk1.8之前的写法
        // Map<字符，次数>  for循环往里放
        HashMap<Character, Integer> result1 = new HashMap<>(32);
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            Integer curVal = result1.get(curChar);
            if (curVal == null) {
                curVal = 1;
            } else {
                curVal += 1;
            }
            result1.put(curChar, curVal);
        }
        // jdk1.8的写法
        // Map.compute，实现计算规则
        HashMap<Character, Integer> result2 = new HashMap<>(32);
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            result2.compute(curChar, (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v += 1;
                }
                return v;
            });
        }
    }
}
