package vincent.algorithm;

/**
 * 二分查找：其实就是两头-1取中值
 */
public class A1biSearch {
    public static void main(String[] args) {
        int [] intArray = {1, 2, 3, 4, 5};
        int a  = 3;
        System.out.println(biSearch(intArray, a));
    }
    public static int biSearch(int[] array, int a){
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high){
            mid = (low + high)/2;
            if(array[mid] == a){
                return mid + 1;
            }else if(array[mid] < a){ // 向右查找
                low = mid + 1;
            }else{ // 向左查找
                high = mid - 1;
            }
        }
        return -1;
    }
}
