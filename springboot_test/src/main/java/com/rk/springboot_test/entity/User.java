//package com.rk.springboot_test.entity;
//
//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.BeanNameAware;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//
///**
// * @author pdai
// */
//@Slf4j
//@ToString
//public class User implements BeanFactoryAware, BeanNameAware, ApplicationContextAware,
//  InitializingBean, DisposableBean {
//  /**
//   * user's name.
//   */
//  private String name;
//
//  /**
//   * user's age.
//   */
//  private int age;
//
//  /**
//   * bean factory.
//   */
//  private BeanFactory beanFactory;
//
//  /**
//   * application context.
//   */
//  private ApplicationContext applicationContext;
//
//  /**
//   * bean name.
//   */
//  private String beanName;
//
//  public User() {
//    log.info("1-user-execute User#new User()");
//  }
//
//  public void setName(String name) {
//    log.info("2-user-execute User#setName({})", name);
//    this.name = name;
//  }
//
//  public void setAge(int age) {
//    log.info("3-user-execute User#setAge({})", age);
//    this.age = age;
//  }
//
//  @Override
//  public void setBeanName(String s) {
//    log.info("4-user-execute BeanNameAware#setBeanName");
//    this.beanName = s;
//  }
//
//  @Override
//  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//    log.info("5-user-execute BeanFactoryAware#setBeanFactory");
//    this.beanFactory = beanFactory;
//  }
//
//  @Override
//  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//    log.info("6-user-execute ApplicationContextAware#setApplicationContext");
//    this.applicationContext = applicationContext;
//  }
//
//  /**
//   * --------以下逻辑是 BeanPostProcess调用，进来的是代理对象
//   * @throws Exception
//   */
//
//
//
//  @Override
//  public void afterPropertiesSet() throws Exception {
//    log.info("7-user-execute InitializingBean#afterPropertiesSet");
//  }
//
//
//  public void doInit() {
//    log.info("8-user-execute User#doInit");
//  }
//
//  @Override
//  public void destroy() throws Exception {
//    log.info("9-user-execute DisposableBean#destroy");
//  }
//
//  public void doDestroy() {
//    log.info("10-user-execute User#doDestroy");
//  }
//
//}
