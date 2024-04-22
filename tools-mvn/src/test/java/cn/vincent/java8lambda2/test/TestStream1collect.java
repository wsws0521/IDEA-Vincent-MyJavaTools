package vincent.java8lambda2.test;

import vincent.java8lambda.pojo.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2.1 collect(Collectors.toList()),将流转换为list 用到lambda表达式
 * 还有toSet()，toMap()等。及早求值。
 * @author HEW376
 *
 */
public class TestStream1collect {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185))
                .collect(Collectors.toList());
        System.out.println(studentList);
    }
}
