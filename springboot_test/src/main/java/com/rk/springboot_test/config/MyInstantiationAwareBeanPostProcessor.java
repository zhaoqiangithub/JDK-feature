//package com.rk.springboot_test.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.PropertyValues;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
//  @Override
//  public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//    if (beanName.equals("user")) {
//      log.info("1-execute InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation for {}", beanName);
//    }
//    return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//  }
//
//  @Override
//  public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//    if (beanName.equals("user")) {
//      log.info("2-execute InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation for {}", beanName);
//    }
//    return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
//  }
//
//  @Override
//  public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//    if (beanName.equals("user")) {
//      log.info("3-execute InstantiationAwareBeanPostProcessor#postProcessProperties for {}", beanName);
//    }
//    return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
//  }
//
//}
