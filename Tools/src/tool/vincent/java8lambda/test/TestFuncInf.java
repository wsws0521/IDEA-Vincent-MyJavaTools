package tool.vincent.java8lambda.test;



import tool.vincent.java8lambda.pojo.Student;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * 函数式接口
 */
public class TestFuncInf {
    public static void main(String[] args) {
        Student student = new Student("Vincent", 29, 182);
        // 1-实现：真假判断接口：与185比较大小
        Predicate<Integer> predicate = x -> x > 185;
        System.out.println("1-我的身高大于185吗？" + predicate.test(student.getHeight()));
        // 2-实现：消费消息接口：打印消息（可用 类名::方法名 语法糖简化写法）
        // Consumer consumer = str -> System.out.println(str);
        Consumer<String> consumer = System.out::println;
        consumer.accept("2-我命由我不由天");
        // 3-实现：映射转换接口<输入Student对象，返回String>：取学生名字
        Function<Student, String> function = Student::getName;
        System.out.println("3-" + function.apply(student));
        // 4-实现：生产消息接口：生产一个整数10
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println("4-" + supplier.get());
        // 5-实现：一元操作接口：取反一个值~
        UnaryOperator<Boolean> unaryOperator = x -> !x;
        System.out.println("5-" + unaryOperator.apply(true));
        // 6-实现：二元操作接口：求积
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println("6-" + binaryOperator.apply(2, 6));
        // 7-自定义函数式接口
        test(() -> "7-我是一个自定义的函数式接口");
    }
    public interface Worker{
        String work();
    }
    public static void test(Worker worker){
        String work = worker.work();
        System.out.println(work);
    }
}
