package com.rk.springboot_test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/order")
public class OrderController {


  private static Map<String, order> map = new ConcurrentHashMap<>();


  @RequestMapping("add")
  public void add() {

    Thread.currentThread().setName("线程1");
    for (int i=0; i< 50000; i++) {
      order a = new order("1","100000","100000","100000","100000","100000", new Date());
      map.put(i+"", a);
    }
    System.out.println("被调用了");

  }


  class order {

    public order(String id1, String id2, String id3, String id4, String id5, String id6, Date date) {
      this.id1 = id1;
      this.id2 = id2;
      this.id3 = id3;
      this.id4 = id4;
      this.id5 = id5;
      this.id6 = id6;
      this.date = date;
    }


    String id1;
    String id2;
    String id3;
    String id4;
    String id5;
    String id6;
    Date date;
  }


}
