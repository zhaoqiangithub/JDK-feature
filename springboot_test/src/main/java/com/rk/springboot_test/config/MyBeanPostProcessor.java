//package com.rk.springboot_test.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class MyBeanPostProcessor implements BeanPostProcessor {
//
//  @Override
//  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
////    if (bean.equals("user")) {
//      log.info("4-execute BeanPostProcessor#postProcessBeforeInitialization for {}", beanName);
////    }
//    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//  }
//
//  @Override
//  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
////    if (bean.equals("user")) {
//      log.info("5-execute BeanPostProcessor#postProcessAfterInitialization for {}", beanName);
////    }
//    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//  }
//
//}
