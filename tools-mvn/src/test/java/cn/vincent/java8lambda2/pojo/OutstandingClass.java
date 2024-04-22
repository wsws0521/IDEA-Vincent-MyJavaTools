package cn.vincent.java8lambda2.pojo;



import cn.vincent.java8lambda.pojo.Student;

import java.util.List;

/**
 * 班级
 */
public class OutstandingClass {
    String name;
    List<Student> students;

    public OutstandingClass(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
