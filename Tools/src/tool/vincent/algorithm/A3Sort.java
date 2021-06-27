package tool.vincent.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序，起手摸牌，斗地主
 */
public class A3Sort {
    public static void main(String[] args) {
//        int[] arr = {4,8,3,1,2,4,6,8,1,2};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(3);
        List<Integer> j = new ArrayList<>();
        j.add(2);
        j.add(4);
        List<List<Integer>> iijj = new ArrayList<>();
        iijj.add(i);
        iijj.add(j);
        System.out.println(merge(iijj));
    }


//    public static void sort(int arr[]){
//        for (int i = 1; i < arr.length; i++) {
//            // 插入的数(从第二个元素开始)
//            int insertVal = arr[i];
//            // 被插入的位置
//            int index = i - 1;
//            while(index >= 0 && insertVal < arr[index]){
//                arr[index + 1] = arr[index];
//                index --; // 准备再与更前者比较
//            }
//            // 把目标数放入合适位置
//            arr[index + 1] = insertVal;
//        }
//    }

    public static List<Integer> merge(List<List<Integer>> lli){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lli.size(); i++) {
            result.addAll(lli.get(i));
        }
        Integer[] arr = new Integer[result.size()];
        result.toArray(arr);
        for (int i = 1; i < arr.length; i++) {
            // 插入的数(从第二个元素开始)
            int insertVal = arr[i];
            // 被插入的位置
            int index = i - 1;
            while(index >= 0 && insertVal < arr[index]){
                arr[index + 1] = arr[index];
                index --; // 准备再与更前者比较
            }
            // 把目标数放入合适位置
            arr[index + 1] = insertVal;
        }
        return Arrays.asList(arr);
    }
}
