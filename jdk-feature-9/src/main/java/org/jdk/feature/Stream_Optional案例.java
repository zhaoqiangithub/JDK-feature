package org.jdk.feature;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Stream_Optional案例 {

    public static void main(String[] args) {

//        1、集合新增of方法
        List<String> a = List.of("K", "Hello");
        System.out.println(a);

        Map map = Map.of("123", 1, "456", 4);
        System.out.println(map);


//        2、stream增加ofNullable、dropWhile、takeWhile和iterate方法
        final long count = Stream.of(1, 2, 3, 4, 5)
                .dropWhile(i -> i % 2 != 0)
                .count();

        assert count == 2;

    }

}
