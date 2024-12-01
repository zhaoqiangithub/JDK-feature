package org.jdk.feature;


import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public final class Singletion {


  public static void main(String[] args) {

//    AtomicInteger atomicInteger = new AtomicInteger(3);
//    atomicInteger.incrementAndGet();
//
//    atomicInteger.lazySet(6);
//    System.out.println(atomicInteger.get());


    RateLimiter rateLimiter = RateLimiter.create(5);
    System.out.println(rateLimiter.acquire());
    System.out.println(rateLimiter.acquire());
    System.out.println(rateLimiter.acquire());
    System.out.println(rateLimiter.acquire());
    System.out.println(rateLimiter.acquire());


  }

}
