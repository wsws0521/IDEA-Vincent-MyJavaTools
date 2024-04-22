package vincent.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 */
public class A4FastSort {
    public static void main(String[] args) {
        int[] arr = {4,8,3,1,2,4,6,8,1,2};
        fastSort(arr, 2, 4);
        System.out.println(Arrays.toString(arr));
    }


    public static void fastSort(int a[], int low, int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end > start){
            // 从后往前比较
            while(end > start && a[end] >= key){
                end --;
                // 如果没有比关键值小的，比较下一个，直至找到并交换位置
                if(a[end] <= key){
                    int tmp = a[end];
                    a[end] = a[start];
                    a[start] = tmp;
                }
            }
            // 从前往后比较
            while(end > start && a[start] <= key){
                start ++;
                // 如果没有比关键值小的，比较下一个，直至找到并交换位置
                if(a[start] >= key){
                    int tmp = a[start];
                    a[start] = a[end];
                    a[end] = tmp;
                }
            }
            // 递归
            if(start > low){
                fastSort(a, low, start - 1);
            }
            if(end < high){
                fastSort(a, end + 1, high);
            }
        }
    }
}
