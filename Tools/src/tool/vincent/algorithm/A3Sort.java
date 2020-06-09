package tool.vincent.algorithm;

import java.util.Arrays;

/**
 * 插入排序，起手摸牌，斗地主
 */
public class A3Sort {
    public static void main(String[] args) {
        int[] arr = {4,8,3,1,2,4,6,8,1,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int arr[]){
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
    }
}
