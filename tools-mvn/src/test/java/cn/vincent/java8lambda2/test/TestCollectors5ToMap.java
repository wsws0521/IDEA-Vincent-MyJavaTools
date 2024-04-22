package vincent.java8lambda2.test;

import vincent.java8lambda.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author HEW376
 *
 */
public class TestCollectors5ToMap {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 23, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        //
        Map<String, Student> collect = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Function.identity(), // 用于表示 自身
                        (oldValue, newValue) -> oldValue // 坑 不带这个的话 万一Map.key冲突则会报错 ： "Duplicate key ** (attempted merging values * and *)",
                ));
    }
}
