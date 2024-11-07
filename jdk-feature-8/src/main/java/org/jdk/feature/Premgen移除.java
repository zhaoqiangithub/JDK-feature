package org.jdk.feature;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * 移除永久代
 *
 * 简单介绍：
 * 元空间，是存放Class和Meta信息，Class在被load的时候，被放入PremGen space区域，他和
 * 存放instance的Heap不同
 * 如果你的App会load很多Class的话，可能出现内存溢出，PremGen space错误。
 *  1、意味着不会再有java.lang.OutOfMemoryError: PermGen问题，
 *  2、也不需要你进行调优和监控内存使用情况。不过你仍然要知道有关类元数据内存的占用。
 *    这个特性，也不能神奇的消除类和类加载器导致的内存泄露的问题
 *
 * PremGen space是Oracle-Sun Hotspot才有的。其他没有
 *
 */
public class Premgen移除 {


  public static void main(String[] args) {
    try {
      URL url = new File("D:\\Users\\zhaoqianng\\IdeaProjects\\JDK-feature\\jdk-feature-8\\target\\classes").toURI().toURL();
      //获取有关类型加载的JMX接口
      ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();

      URL[] urls = {url};
      ArrayList<ClassLoader> classLoaders = new ArrayList<>();
      while (true) {
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        classLoaders.add(urlClassLoader);
        urlClassLoader.loadClass("ClassAForTestOOm");

        //显示数量信息(共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目)
//        System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
//        System.out.println("active: " + loadingBean.getLoadedClassCount());
//        System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }


}


