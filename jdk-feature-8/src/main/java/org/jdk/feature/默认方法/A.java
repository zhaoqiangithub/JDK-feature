package org.jdk.feature.默认方法;

public interface A {
  default void foo() {
    System.out.println("吃饭");
  }
}
