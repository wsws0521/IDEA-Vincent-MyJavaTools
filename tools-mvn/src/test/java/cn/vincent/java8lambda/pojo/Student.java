package cn.vincent.java8lambda.pojo;

public class Student {
    String name;
    int age;
    int height;
    SpecialityEnum specialityEnum;

    public Student(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public SpecialityEnum getSpecialityEnum() {
        return specialityEnum;
    }

    public void setSpecialityEnum(SpecialityEnum specialityEnum) {
        this.specialityEnum = specialityEnum;
    }
}
