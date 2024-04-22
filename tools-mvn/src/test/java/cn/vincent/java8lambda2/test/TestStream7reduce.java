package cn.vincent.java8lambda2.test;

import java.util.stream.Stream;

/**
 * reduce 操作可以实现从一组值中生成一个值。 在上述例子中用到的 count 、 min 和 max 方法，因为常用而被纳入标准库中。
 * 事实上，这些方法都是 reduce 操作。及早求值。
 *
 * @author HEW376
 *
 */
public class TestStream7reduce {
    public static void main(String[] args) {
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc+ x);
        System.out.println(reduce);
    }
}
// 我们看得reduce接收了一个初始值为0的累加器，依次取出值与累加器相加，最后累加器的值就是最终的结果。
