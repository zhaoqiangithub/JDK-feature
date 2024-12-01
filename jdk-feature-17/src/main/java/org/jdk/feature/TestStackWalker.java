package org.jdk.feature;

import java.util.HashMap;
import java.util.Map;

public class TestStackWalker {

    public static void main(String[] args) throws InterruptedException {

//            // 创建 StackWalker 实例
//            StackWalker walker = StackWalker.getInstance();˙
//
//            // 获取调用栈并打印方法名和类名
//            walker.walk(frameStream -> {
//                frameStream.forEach(frame -> {
//                    System.out.println("Class: " + frame.getDeclaringClass().getName());
//                    System.out.println("Method: " + frame.getMethodName());˙
//                    System.out.println("Line number: " + frame.getLineNumber());
//                    System.out.println();
//                });
//                return null; // walk 方法需要返回一个值
//            });


        // 内存溢出
//        ArrayList<Byte[]> bytes = new ArrayList<>();
//        while (true) {
//            bytes.add(new Byte[1 * 1024 * 1024]); // 1M
//        }


        // 改为虚引用
//        List<WeakReference<Object>> bytes = new ArrayList<>();
//        while (true) {
//            bytes.add(new WeakReference<>(new Object())); // 1M
//        }

        Map<Integer, String> map = new HashMap<>();
        int i = 0;
        while (true) {
            Thread.sleep(10000);
            map.put(i, String.valueOf(i++));
        }


    }
}
