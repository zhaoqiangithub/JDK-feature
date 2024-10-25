package org.jdk.feature;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;


public class 类型推断优化 {

  public static void main(String[] args) {

    // 泛型：类型变量，可作用于类、接口、和方法上
    // 泛型的优点：保证提供程序的安全同时，向后兼容
    // 泛型的尴尬：每次定义都需要写明泛型的类型

    // 1、jdk7，初始化对象，可以推断类型
    HashMap<String, String> before = new HashMap<String, String>();
    // 加上<>，才表示自动类型推断
    HashMap<String, String> after = new HashMap<>();

    // 2、jdk8泛型改进
    List<String> listBefore = Arrays.<String>asList("a", "b", "c");
    List<String> listAfter = Arrays.asList("a", "b", "c");

    List<String> objects = Collections.<String>emptyList();
    List<String> objects1 = Collections.emptyList();

    Predicate<String> predicate = s -> s.isEmpty();

  }
}
