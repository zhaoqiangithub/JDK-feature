package org.jdk.feature;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 调用一个方案，得到了返回值，却不能直接将返回值作为参数，去调用别的方法
 * 首先需要判断返回值是否为null
 * 在非空前提下，将其作为其他方法的参数
 *
 * 使用optional，解决此问题
 *
 * 可以为null的容器对象。如果值存在ifPresent()方法会返回true，调用get方法会返回对象
 */
public class Optional类 {

  public static void main(String[] args) {
    new Optional类().optional2();
  }


  private void optional1() {
    // 1、of。为非null值创建一个optional，传入null报错，空指针
    Optional<String> aaa = Optional.of("aaa");
//    System.out.println(aaa.get());

    // 2.ofNullable，为指定值创建一个optional，传入null，不报错。get，报错没有找到元素异常
    Optional<String> aaa1 = Optional.ofNullable(null);
//    System.out.println(aaa1.get());

    // 3、isPresent，存在值返回true
    System.out.println(aaa.isPresent());

    // 4、get。如果optional有值，返回。否则抛出NoSuchElemenetExcetion
    //    System.out.println(aaa1.get());

    // 5、ifPresent.如果optional实例有值，调用其consumer，否则不处理(consumer为，消费型内置接口函数)
    aaa1.ifPresent((n) -> System.out.println(n.length()));

    // 6、orElse，有值将其返回，否则返回其他值, orElseGet，接受supplier接口
    System.out.println(aaa.orElse("no value"));
    System.out.println(aaa1.orElseGet(() -> "no value"));
    // 7、orElseThrow，接受exceptionSupplier接口
    aaa1.orElseThrow(RuntimeException::new);
  }

  private void optional2() {
    // 1、map，
    // 如果有值，则对其执行调用mapping函数得到返回值。
    // 如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
    Optional<String> aaa = Optional.ofNullable("aaa");
    Optional<String> upperName = aaa.map(String::toUpperCase);
    System.out.println(upperName.orElse("no value"));

    // 2、flatMap
    // 和map类似，不过flatMap中lambda表达式，返回值必须是Optional
    Optional<String> upperName1 = aaa.flatMap((n) -> Optional.of(n.toUpperCase()));
    System.out.println(upperName1.orElse("no value1"));

    // 3、filter
    // 如果有值，并且满足断言条件，返回包含该值的Optional，否则返回空的Optional
    Optional<String> longName = aaa.filter((n) -> n.length() > 5);
    System.out.println(longName.orElse("no value3"));

    // 判空方法1
    // A
    A a = new A();
    Optional.ofNullable(a)
      .map((aa) -> aa.getB())
      .map((b) -> b.getC())
      .map((c) -> c.getD()).ifPresent((d) -> System.out.println(d));

    // 判空方法2
    Supplier supplier = () -> a.getB().getC().getD();

    Optional op1;
    try {
      Object o = supplier.get();
      op1 = Optional.ofNullable(o);
    } catch (NullPointerException e) {
      op1 = Optional.empty();
    }
    op1.ifPresent((n) -> System.out.println(n));
  }

  class A {

    public B b;
    B getB() {
      return b;
    }
  }

  class B {
    public C c;
    C getC() {
      return c;
    }
  }

  class C {
    public String d;
    String getD() {
      return d;
    }
  }


}
