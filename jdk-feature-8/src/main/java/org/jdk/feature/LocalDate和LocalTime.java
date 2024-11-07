package org.jdk.feature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 每个Java开发人员都应该至少了解这套新的API中的这五个类:
 * Instant 它代表的是时间戳，比如2014-01-14T02:20:13.592Z，这可以从java.time.Clock类中获取，像这样: Instant current = Clock.system(ZoneId.of(“Asia/Tokyo”)).instant();
 * LocalDate 它表示的是不带时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等。
 * LocalTime – 它表示的是不带日期的时间
 * LocalDateTime – 它包含了时间与日期，不过没有带时区的偏移量
 * ZonedDateTime – 这是一个带时区的完整时间，它根据UTC/格林威治时间来进行时区调整
 */
public class LocalDate和LocalTime {

    public static void main(String[] args) throws IOException {


        // 1、JDK增加无符号支持

//        System.out.println(Integer.MAX_VALUE + 1);
//        System.out.println(Integer.MAX_VALUE );


//        long maxUnsignedInt = (1l << 32) - 1;
//        String string = String.valueOf(maxUnsignedInt);
//        System.out.println(string);
//        int unsignedInt = Integer.parseUnsignedInt(string, 10);
//        System.out.println(unsignedInt);
//        String string2 = Integer.toUnsignedString(unsignedInt, 10);
//        System.out.println(string2);


        // 2、JDK8处理文件 FIle.list，支持转为stream
        // 3、JDK8查查找文件，File。find 支持转为stream
        // 4、JDK8读写文件 File.readAllLines、lines、newBufferedReader、newBufferedWriter
        Path path = Paths.get("D:\\test.java");
//        List<String> lines = Files.readAllLines(path);
//        lines.add("print('foobar')");
//        Files.write(Paths.get("D:\\test1.java"), lines);

        try (Stream<String> lines = Files.lines(path)) {
            lines
//            .filter(line -> line.contains("test"))
                .forEach(System.out::println);
        }


        // 5、JDK Random
//        Random random = new Random();
//        DoubleStream doubles = random.doubles();
//        doubles.forEach(System.out::println);

//        IntStream ints = random.ints(1, 100);
//        ints.forEach(System.out::println);
//        ints.limit(10).forEach(System.out::println);
//        List<Integer> collect = ints.limit(100)
//                .boxed()
//                .collect(Collectors.toList());
//        collect.forEach(System.out::println);

        // 6、base64
        String base64 = Base64.getEncoder().encodeToString("some thing".getBytes("UTF-8"));
        System.out.println(base64);
        byte[] decode = Base64.getDecoder().decode(base64);
        String s = new String(decode, "UTF-8");
        System.out.println(s);
    }
}
