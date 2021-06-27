package tool.vincent.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 牛客：反转链表   输入  {123}  返回  {321}
 * 大牛纯粹应试
 */
public class A7ListNode2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (true) {
            input = br.readLine();
            if(null == input || input.length() == 0){
                break;
            }
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append("}").append(input.substring(1, input.length() - 1)).append("{").reverse());
        }
    }
}
