package org.jdk.feature.pLambda函数编程;

import org.jdk.feature.Lambda函数编程;

import java.util.HashMap;
import java.util.function.*;

public class TestMyInterface {


  public static void main(String[] args) {


    /**
     * funcitonalInterface 方法接口
     * 被打注解的接口，只能有一个抽象方法，有两种例外
     *
     * 1、接口允许有实现的方法
     * 2、声明的方法和java.lang.Object的某个方法一样，可以不当做未实现的方法
     *
     * 如果一个类型，被这个注解修饰，编译器要求，比如是interface，并且满足interface的所有要求，包含两个抽象方法报错
     */

    // 1、自定义函数接口
//    IMyInterface myInterface = () -> System.out.println(" 实现了接口的方法，myMethod");
//    myInterface.myMethod();
    IMyInterface<Lambda函数编程> myInterface = Lambda函数编程::new;
    System.out.println(myInterface.myMethod());

    // 2、四个内置函数接口
    // 2.1、消费型接口，函数接口，接受实现过的函数体
    Consumer<String> consumer = (p) -> System.out.println(p);
    consumer.accept("uuu");

    // 2.2、供给型接口，函数接口，提供
    Supplier<TestMyInterface> supplier = TestMyInterface::new;
    System.out.println(supplier.get());

    // 2.3、断定型接口
    Predicate<String> predicate = n -> n.length() > 1;
    String str = "aaa";
    System.out.println(predicate.test(str));
    System.out.println(predicate.negate().test(str));

    // 2.4、函数型接口
    Function<String ,Integer> toInteger = Integer::valueOf;
    System.out.println(toInteger.apply("123"));

    System.out.println(String.join(":", "123", "gai"));

    HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
    objectObjectHashMap.put("123", 1);
    Integer i = objectObjectHashMap.computeIfAbsent("124", (key) -> {
      System.out.println(key);
      return 999;
    });
    System.out.println(objectObjectHashMap);
  }
}
