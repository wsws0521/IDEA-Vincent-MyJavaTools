package vincent.java8lambda2.test;



import vincent.java8lambda.pojo.Student;
import vincent.java8lambda.pojo.StudentListWrapListWrap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author HEW376
 *
 */
public class TestStream4flatmap {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        List<Student> studentList = Stream
                .of(students, Arrays.asList(new Student("艾斯", 25, 183), new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(studentList);

        // 多层套娃 拍平
        List<StudentListWrapListWrap1> listListList = new ArrayList<>();
        List<Student> collect = listListList.stream()
                .flatMap(listList -> listList.getStudentListWrap1List().stream())
                .flatMap(list -> list.getStudentList().stream())
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
