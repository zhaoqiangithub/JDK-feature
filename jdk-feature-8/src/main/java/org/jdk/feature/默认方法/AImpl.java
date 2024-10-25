package org.jdk.feature.默认方法;

public class AImpl implements A{

  public static void main(String[] args) {
    // 接口，增加defualt关键字，可以增加实现
    // 什么是默认方法：接口可以有实现方法，不需要实现类去实现其方法，只需要在方法明前面加defaultj即可
    // 为什么需要：接口是双刃剑，好像面向抽象而不是具体，缺点是，修改接口需要修改所有实现
    //  接口增加默认方法，可以修改接口，不用修改所有实现。解决新增接口和现有实现的冲突


    AImpl a = new AImpl();
    a.foo();


    // 1、多重继承问题
    // 原则1：声明在类中，方法优先于任何默认方法
    // 原则2：否则，优先取最短路径

  }
}
