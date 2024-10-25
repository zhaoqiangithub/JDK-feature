package org.jdk.feature;

public class JRE精简 {

//   即JEP161(http://openjdk.java.net/jeps/161 ),
//   该特性定义了Java SE平台规范的一些子集，使java应用程序不需要整个JRE平台即可部署和运行在小型设备上。开发人员可以基于目标硬件的可用资源选择一个合适的JRE运行环境。#

//  JRE精简好处
//  更小的Java环境需要更少的计算资源。
//  一个较小的运行时环境可以更好的优化性能和启动时间。
//  消除未使用的代码从安全的角度总是好的。
//  这些打包的应用程序可以下载速度更快。

//  紧凑JRE分三种。compact1、compact2、compact3.compact1<compact2<compact3

//  使用场景
//  1、嵌入式设备
//  2、容器化应用
//  3、瘦客户端、应用分发
//  4、提高安全性

//  使用
//  1、jdk8工具，jdeps，分析应用程序依赖的profile, jdeps -P,
//     或者使用 javac -profile compact2 Test.java ，检查代码是所使用的类是否在指定的配置中（比如compact1）
//  2、手动精简jre
//    2.1 手动移除：保留compact1模块中类库文件，java -tf查看jar文件内容，决定是否删除
//    2.2 使用第三方工具（如 ProGuard）：
//  3、测试精简后的JRE




}
