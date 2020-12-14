package tool.vincent.java8lambda2.test;



import tool.vincent.java8lambda.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 如果将所有学生的名字拼接起来，怎么做呢？通常只能创建一个StringBuilder，循环拼接。
 * 使用Stream，使用Collectors.joining()简单容易。
 * @author HEW376
 *
 */
public class TestCollectors4ConcatStr {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        String names = students.stream()
                .map(Student::getName).collect(Collectors.joining(",","[","]"));
        System.out.println(names);
    }
    // joining接收三个参数，第一个是分界符，第二个是前缀符，第三个是结束符。
    // 也可以不传入参数Collectors.joining()，这样就是直接拼接。
}
