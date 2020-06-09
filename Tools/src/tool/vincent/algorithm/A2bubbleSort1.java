package tool.vincent.algorithm;

/**
 * 冒泡排序算法：前者>后者，则主动下沉一位
 */
public class A2bubbleSort1 {
    public static void main(String[] args) {
        int[] a = {4,8,3,1,2,4,6,8,1,2};
        bubbleSort1(a, 2);
        System.out.println(a);
    }

    /**
     *
     * @param a 被排序数组
     * @param n 排序次数
     */
    public static void bubbleSort1(int[] a, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if(a[j-1] > a[j]){ // 如果前者>后者，交换
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
