package tool.vincent.algorithm;

import java.util.ArrayList;

/**
 * 牛客：最小的几个数
 * 输入：
 * [4,5,1,6,2,7,3,8],4
 * 返回：
 * [1,2,3,4]
 */
public class A8Min4 {
    public static void main(String[] args) {
        int[] input = {};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int length = input.length;
        ArrayList<Integer> result = new ArrayList<>(k);
        if(length > 0 && length >= k){
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    if(input[j - 1] > input[j]){
                        int temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                    }
                }
            }
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
        }
        return result;
    }
}
