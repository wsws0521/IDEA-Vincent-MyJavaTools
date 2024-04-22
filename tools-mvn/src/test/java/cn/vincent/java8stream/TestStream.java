package vincent.java8stream;

import vincent.java8stream.Pojo.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @PackageName: tool.vincent.java8stream
 * @ClassName: TestStream
 * @Description: 尽量让集合操作像数据库一样方便
 * @author: Vincent
 * @date: 2020/12/9 14:41
 */
public class TestStream {
    public static void main(String[] args) {
        // 创建
//        try0Create();
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        // 使用

    }
    public static void try0Create(){
        // 1-java.util.Collection.stream() 用集合创建流
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream(); // 创建一个顺序流
        Stream<String> parallelStream = list.parallelStream(); // 创建一个并行流：多线程处理一个流，快 & 无序
        stream.parallel(); // 转换成并行流
        // 2-java.util.Arrays.stream(T[] array) 用集合创建流
        int[] array = {1,3,5,7,9};
        IntStream intStream = Arrays.stream(array);
        // 3-用 stream 的静态方法直接创建
        Stream<Integer> stream3 = Stream.of(1,3,5,7,9);
        Stream<Integer> stream31 = Stream.iterate(0, (x) -> x+3).limit(4);
        stream31.forEach(System.out::println);
        Stream<Double> stream32 = Stream.generate(Math::random).limit(3);
        stream32.forEach(System.out::println);
    }

    /**
     * 1-遍历/匹配
     */
    public static void try1ForeachFindMatch(){
        // foreach/find/match 每个元素都是Optional
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        list.stream().filter(x -> x > 6).forEach(System.out::println); // 遍历输出符合条件的元素
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst(); // 匹配第一个
        System.out.println("匹配第一个值：" + findFirst.get());
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny(); // 匹配任意（适用于并行流）
        System.out.println("匹配任意一个值：" + findAny.get());
        boolean anyMatch = list.stream().anyMatch(x -> x < 6); // 是否包含符合特定条件的元素
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    /**
     * 2-筛选
     * @param personList
     */
    public static void try2Filter(List<Person> personList){
        // 筛选出Integer集合中大于7的元素，并打印出来
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);

        // 筛选员工中工资高于8000的人，并形成新的集合。形成新集合依赖collect（收集）
        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);
    }

    /**
     * 3-聚合
     * @param personList
     */
    public static void try3MaxMinCount(List<Person> personList){
        // 1-获取String集合中最长的元素
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

        // 2-获取Integer集合中的最大值
        List<Integer> intList = Arrays.asList(7, 6, 9, 4, 11, 6);
        // 自然排序
        Optional<Integer> intMax = intList.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> intMax2 = intList.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + intMax.get());
        System.out.println("自定义排序的最大值：" + intMax2.get());

        // 3-获取员工工资最高的人
        Optional<Person> maxSalary = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + maxSalary.get().getSalary());

        // 4-计算Integer集合中大于6的元素的个数
        List<Integer> intList2 = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = intList2.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }

    /**
     * 4-映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
     * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。（把流水线上的每个产品重新包装下）
     * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。（把流水线上每个产品拆碎，重新放到线上）
     * @param personList
     */
    public static void try4Map(List<Person> personList){
        // 1-英文字符串数组的元素全部改为大写。整数数组每个元素+3
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strList);
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + intListNew);

        // 2-将员工的薪资全部增加 1W
        // 不改变原来员工集合的方式（生成一个新的 personList）
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("不动原来，改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("不动原来，改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        // 改变原来员工集合的方式（在原来的 personList 上面直接改）
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("动原来，改动前：" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        System.out.println("动原来，改动后：" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        // (flatMap)将两个字符数组合并成一个新的字符数组
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());
        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }

    /**
     * 5-归约
     * 也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     * @param personList
     */
    public static void try5Reduce(List<Person> personList){
        // 1-求Integer集合的元素之和、乘积和最大值
        // 求和
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y); // 方式1
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum); // 方式2
        Integer sum3 = list.stream().reduce(0, Integer::sum); // 方式3
        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        System.out.println("list求积：" + product.get());
        // 求最大值
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y); // 方式1
        Integer max2 = list.stream().reduce(1, Integer::max); // 方式2
        System.out.println("list求和：" + max.get() + "," + max2);

        // 2-求所有员工的工资之和 和 最高工资
        // 求工资之和
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum); // 方式1
        Integer sumSalary2 = personList.stream().reduce(0, (ss2, p) -> ss2 += p.getSalary(), (sss1, sss2) -> sss1 + sss2); // 方式2
        Integer sumSalary3 = personList.stream().reduce(0, (ss3, p) -> ss3 += p.getSalary(), Integer::sum); // 方式3
        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        // 求最高工资
        Integer maxSalary = personList.stream().reduce(0, (ms1, p) -> ms1 > p.getSalary() ? ms1 : p.getSalary(), Integer::max); // 方式1
        Integer maxSalary2 = personList.stream().reduce(0, (ms2, p) -> ms2 > p.getSalary() ? ms2 : p.getSalary(), (ms21, ms22) -> ms21 > ms22 ? ms21 : ms22); // 方式2
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }

    /**
     * 6-收集-1-归集
     * collect主要依赖java.util.stream.Collectors类内置的静态方法。
     * toList/toSet/toMap/toCollection/toConcurrentMap = 归集 = 因为*流不存储数据*，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合里。
     * @param personList
     */
    public static void try6ToCollect1(List<Person> personList){
        // 前面也有用过，就是追加 .collect，没啥说的
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("toList:" + listNew);
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println("toSet:" + set);
        // 对象集合同理
        Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println("toMap:" + map);
    }
    /**
     * 6-收集-2-统计
     * collect主要依赖java.util.stream.Collectors类内置的静态方法。
     * Collectors提供了一系列用于数据统计的静态方法：count/averagingInt.Long.Double/max.minBy/summingInt.Long.Double/summarizingInt.Long.Double
     * @param personList
     */
    public static void try6ToCollect2(List<Person> personList){
        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);
    }
    /**
     * 6-收集-3-分组
     * collect主要依赖java.util.stream.Collectors类内置的静态方法。
     * partitioningBy   ：分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分
     * groupingBy       ：分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组
     * @param personList
     */
    public static void try6ToCollect3(List<Person> personList){
        // 将员工按薪资是否高于8000分为两部分；将员工按性别和地区分组
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);
    }
    /**
     * 6-收集-4-接合
     * collect主要依赖java.util.stream.Collectors类内置的静态方法。
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
     * @param personList
     */
    public static void try6ToCollect4(List<Person> personList){
        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + names);

        List<String> list = Arrays.asList("A", "B", "C");
        String string = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + string);
    }
    /**
     * 6-收集-5-归约
     * collect主要依赖java.util.stream.Collectors类内置的静态方法。
     * Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持。
     * @param personList
     */
    public static void try6ToCollect5(List<Person> personList){
        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sum);
        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());
    }
    /**
     * 7-排序，中间操作
     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     * @param personList
     */
    public static void try7Sort(List<Person> personList){
        // 将员工按工资由高到低（工资一样则按年龄由大到小）排序
        // 按工资增序排序
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄自然排序（从小到大）
        List<String> newList3 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（从大到小）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());

        System.out.println("按工资自然排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄自然排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);
    }
    /**
     * 8-提取/组合：流也可以进行合并、去重distinct、限制limit、跳过skip等操作。
     * @param personList
     */
    public static void try8DistinctLimitSkip(List<Person> personList){
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }
}
