package toolsmvn.vincent.builder;

import java.util.Date;

public class TestBuildObject {

    public static void main(String[] args) {
        // 优点：链式调用，一行，避免看花眼 重复set
        // 缺点：冗余的 Builder 类，一次性set
        BuildObject buildObject = new BuildObject.ObjectBuilder(99, "Vincent")
                .type(1)
                .content("是个狠人")
                .status(0)
                .finishDate(new Date())
                .build();

        System.out.println(buildObject.toString());
        // 需要，以及大量相等重复的成员变量，大大增加了代码量，维护难度相对较大；
        // 只适合一次赋值创建对象，多次赋值的场景还需要新增 set 方法配合，不是很灵活；
    }
}
