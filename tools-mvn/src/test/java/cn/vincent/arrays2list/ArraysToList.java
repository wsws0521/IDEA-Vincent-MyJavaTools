package cn.vincent.arrays2list;

import java.util.*;

/**
 * 数组转List的几种方式
 */
public class ArraysToList {
    public static void main(String[] args) {
        // Arrays.asList 不支持 add
        // 因为返回的是 java.util.Arrays.ArrayList
        // 而不是       java.util.ArrayList
        // 没有add方法
//        method1();
        // 重新包装 支持  add
//        method2();
        // List 数量巨大  Collections.addAll()
        method3();
    }

    private static void method1(){
        String[] strArray = new String[2];
//        String[] strArray1 = {"1", "2"};
        List list = Arrays.asList(strArray);
        list.add("1");
        System.out.println(list);
    }
    private static void method2(){
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray));
        list.add("1");
        System.out.println(list);
    }
    private static void method3(){
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<String>(strArray.length);
        Collections.addAll(list, strArray);
        list.add("1");
        System.out.println(list);
    }
}
