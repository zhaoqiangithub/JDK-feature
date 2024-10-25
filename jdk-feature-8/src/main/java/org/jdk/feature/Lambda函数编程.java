package org.jdk.feature;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Lambda函数编程 {

    private String n1 = "a";
    private static String n2 = "b";

    public static void main(String[] args) {
        new Lambda函数编程().stream3();

    }

    // lambda表达式 -------------------------------------------------------------------------------

    /**
     * 1、
     * lambda表达式，如果参数没有修改，可以放方法引用，否则只能用完整的lambda表达式
     */
    private void lambda() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");

        // 1、完整的lambda表达式
        list.forEach(n -> System.out.println(n));
        // 2、如果不对参数进行修改，可以修改为方法引用
        list.forEach(System.out::println);
        // 3、如果修改，只能用完整的lambda表达式
        list.forEach((String n) -> System.out.println("*" + n + "*"));
        // 4、省略类型，编译器可以推算出来
        list.forEach(n -> System.out.println("*" + n + "*"));
    }


    /**
     * 2、
     * lambda内部，可以使用，静态、非静态和局部变量，这叫变量捕获
     * lambda表达式，又成为闭包或者匿名函数
     */
    private void lambda2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.forEach(n -> System.out.println(n1 + " " + n2 + " " + n));
    }

    /**
     * 3、
     * lambda编译后，编译器内部翻译成了私有方法。
     * 使用invokedynamic指令，不直接为lambda生成一个匿名类，而是在运行期，生成一个lambda对象实例，和私有方法绑定
     */
    private void lambda3() {
//        private void lambda$lambda2$0(java.lang.String);
    }

    /**
     * 4、
     * 只能引用final的变量，不能再lambda内部修改定义在域外的变量
     */
    private void lambda4() {
        List<Integer> list = Arrays.asList(1, 3, 3);
        int num = 2;
//        list.forEach(n -> System.out.println(num++));
    }

    // stream -------------------------------------------------------------------------------
    // 使用理想方式，形式一个惰性求值链，用只有一个及早求值的操作返回想要的结果。类似于见建造者模式

    /**
     * 1、stream过滤，返回为真 的结果
     */
    private void stream1() {
        List<String> list = Arrays.asList("p1", "p2", "p3", "p4");
        // 返回，为真 的结果
        Stream<String> p1 = list.stream().filter(f -> f.equals("p1"));
        p1.forEach(System.out::println);

        // 及早求值操作
        List<String> p2 = list.stream().filter(f -> f.equals("p2")).collect(Collectors.toList());
    }

    /**
     * 2、stream的顺序执行、和并行
     * 原理：将数据分为小部分，启动多个线程执行，将结果合并
     */
    private void stream2() {
        List<String> list = Arrays.asList("p1", "p2", "p3", "p4");
        // 顺序执行，读完一个再读下一个
        List<String> collect = list.stream().collect(Collectors.toList());
        // 并行流，数据分为多段，每个在不同线程中执行，将结果一起输出
        List<String> collect1 = list.stream().parallel().collect(Collectors.toList());

        // 并行测试
        long t0 = System.nanoTime();
        int[] array = IntStream.range(0, 100_000_000).filter(p -> p % 2 == 0).toArray();
        long t1 = System.nanoTime();
        int[] array1 = IntStream.range(0, 100_000_000).parallel().filter(p -> p % 2 == 0).toArray();
        long t2 = System.nanoTime();
        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
    }

    /**
     * 3、stream常用方法
     */
    private void stream3() {
        // 1、匿名类
        new Thread(() -> System.out.println("写一个匿名类")).start();

        // 2、foreach
        List<String> list = Arrays.asList("p1", "p2", "p3", "p4");
        list.forEach(n -> System.out.println(n));
        // 方法引用
        list.forEach(System.out::println);

        // 3、方法引用
        // 3.1 构造引用
        // () -> new LambdaFeature();
        // LambdaFeature::new

        // 3.2 对象
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);

        // 3.3 类名::静态方法
        Stream<Double> generate = Stream.generate(
          () -> Math.random()
        );
        Stream<Double> generate1 = Stream.generate(Math::random);

        // 3.4 类名::实例方法
        // TreeSet<String> charSequences = new TreeSet<>(String::compare);

        // 4.Filter && Predicate
        // 4.1 predicate传递
        List<String> list1 = Arrays.asList("p1", "p2", "p3", "p4");
        filter(list1, (n) -> n.startsWith("p"));

        // 4.2 多个filter组合，用and
        Predicate<String> start = n -> n.startsWith("p");
        Predicate<String> end = n -> n.length() > 1;
        list1.stream().filter(start.and(end)).forEach(n -> System.out.println(n));

//         5.Map, map映射
//         5.1 reduce，合并所有值，需要两个参数
//         Optional reduce = list1.stream().map(n -> n + "test").reduce((a, b) -> a + "-" + b);
//         reduce.ifPresent(System.out::println);
//
//         5.2 Collectors
//         Collectors.joining(", ")
//         Collectors.toList()Collectors.toSet() ，生成set集合
//         Collectors.toMap(MemberModel::getUid, Function.identity())
//         Collectors.toMap(ImageModel::getAid, o -> IMAGE_ADDRESS_PREFIX + o.getUrl())
//         String collect = list1.stream().map(n -> n.toUpperCase()).collect(Collectors.joining(","));
//         System.out.println(collect);
//
//         5.2 flatMap（将多个stream合并成一个扁平的流。拉平映射，适用于二维数组和多个嵌套list）
//         List<List<String>> list = Arrays.asList(Arrays.asList("Java", "Python"), Arrays.asList("C++", "Go"));
//         List<String> collect1 = list.stream().flatMap(n -> n.stream()).collect(Collectors.toList());
//         System.out.println(collect1);
//
//         5.3 distinct
//         List<String> list2 = Arrays.asList("p1", "p2", "p3", "p4", "p4");
//         list2.stream().forEach(System.out::println);
//
//         5.4 count
//         System.out.println("list2.stream().count() = " + list2.stream().count());
//
//         5.5 Match 匹配
//         System.out.println(list2.stream().anyMatch(n -> n.equals("p1")));
//         System.out.println(list2.stream().allMatch(n -> n.equals("p1")));
//         System.out.println(list2.stream().noneMatch(n -> n.equals("p5")));

//         5.6 min,max,summaryStatistics,最大值、最小值
//         List<Integer> list = Arrays.asList(1, 2, 3, 4, 4);
//         Integer i = list.stream().min(Comparator.naturalOrder()).get();
//         System.out.println(i);
//
//         summaryStatistics 在IntStream中
//         IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(n -> n).summaryStatistics();
//         System.out.println(intSummaryStatistics.getAverage());
//         System.out.println(intSummaryStatistics.getMax());

//         5.7 peek 只包含一个空方法体
//        List<Integer> collect = list.stream().filter(n -> n % 2 == 0)
//          .peek(n -> System.out.println(n))
//          .collect(Collectors.toList());
    }


    private static void filter(List<String> list, Predicate<String> predicate) {
        list.stream().filter((n) -> predicate.test(n))
          .forEach((n) -> System.out.println(n + " "));
    }
}