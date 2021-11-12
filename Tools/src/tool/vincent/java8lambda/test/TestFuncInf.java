package tool.vincent.java8lambda.test;



import org.junit.Test;
import tool.vincent.java8lambda.pojo.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    /* **************** 以上是  单个参数，下面尝试双参 BiFunction *********************** */
    // 假设要求把两个长度相等的列表合并成一个结果列表
    @Test
    public void combine2Lists(){
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<String> result = new ArrayList<>();
        for (int i=0; i < list1.size(); i++) {
            result.add(list1.get(i) + list2.get(i));
        }
        System.out.println(result);
    }
    private static <T, U, R> List<R> listCombiner(
            List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
    @Test
    public void combine2Lists2(){
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        System.out.println(listCombiner(list1, list2, (a, b) -> a + b));

        List<Double> list11 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Float> list22 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Boolean> result1122 = listCombiner(list11, list22, (a, b) -> a > b);
        List<Boolean> result2211 = listCombiner(list1, list2, (a, b) -> a.equals(b));
//        List<Boolean> result22110 = listCombiner(list1, list2, (a, b) -> Float::equals);
//        List<Integer> result = listCombiner(list1, list2, Double::compareTo);
//        List<Boolean> result = listCombiner(list1, list2, asBiFunction(Double::compareTo).andThen(i -> i > 0));
        System.out.println(result1122);
        System.out.println(result2211);

        List<Double> list111 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Float> list222 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Boolean> result2 = listCombiner(list111, list222, this::firstIsGreaterThanSecond);
        System.out.println(result2);
    }
    private boolean firstIsGreaterThanSecond(Double a, Float b) {
        return a > b;
    }

    /* **************** 更多参数，参考 *********************** */
    // github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-8-2

}
