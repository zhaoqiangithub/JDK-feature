# JDK-feature
Welcome to the JDK-feature project!
This project introduces the new features from JDK 8 to JDK 21.
You can use cases to describe and demonstrate the features in a clearer form and with cases. 
For more information, please refer to the JDK official documentation.

## Getting Started
* clone this project
* Read the code and features according to the readme

## Feature Overview
在了解 JDK 1.8 到 JDK 21 的新特性时，不仅要掌握各版本引入的语言和库特性，还要理解 HotSpot 虚拟机中垃圾收集器在新生代和老年代的使用。以下是从 JDK 1.8 到 JDK 21 的详细特性介绍，涵盖虚拟机、垃圾收集器以及新生代和老年代回收器的详细变化。

### 1. JDK 8 (2014)
- **主要新特性**：
    - **Lambda 表达式**：简化了匿名内部类的编写，支持函数式编程。
    - **Stream API**：提供对集合的高效处理操作。
    - **默认方法和静态方法**：接口可以有默认方法和静态方法。
    - **Optional 类**：解决空指针异常问题。
    - **java.time 包**：提供了现代化的日期时间 API。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**Parallel Scavenge (PS)**，一种并行垃圾回收器，适合高吞吐量。
- **老年代垃圾回收器**：**Parallel Old (PO)**，与 Parallel Scavenge 配合使用，也适合高吞吐量。
- **其他可选垃圾回收器**：
    - **CMS (Concurrent Mark-Sweep)**：适合低延迟场景，使用并发标记-清除算法。
    - **G1 (Garbage-First)**：针对大堆内存应用，整合了新生代和老年代的回收。

### 2. JDK 9 (2017)
- **主要新特性**：
    - **模块化系统 (Project Jigsaw)**：模块化 Java 平台，允许更细粒度的依赖管理。
    - **JShell**：Java 的交互式 REPL 环境。
    - **改进的 Stream API**：支持 takeWhile、dropWhile 和 iterate 等新方法。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1 (Garbage-First)**，在 JDK 9 中成为默认垃圾回收器。
- **老年代垃圾回收器**：**G1** 也负责老年代垃圾回收，与新生代一体化管理。
- **其他可选垃圾回收器**：CMS、Parallel Scavenge + Parallel Old。

### 3. JDK 10 (2018)
- **主要新特性**：
    - **局部变量类型推断**：`var` 关键字允许局部变量的类型推断。
    - **垃圾回收器接口统一**：引入了一个垃圾回收器接口，简化了垃圾回收器的实现。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1** 作为默认回收器。
- **老年代垃圾回收器**：**G1**。
- **其他可选垃圾回收器**：CMS、Parallel Scavenge + Parallel Old。

### 4. JDK 11 (2018) (LTS)
- **主要新特性**：
    - **HTTP Client API**：正式版的 HTTP/2 和 WebSocket 客户端 API。
    - **ZGC（Z Garbage Collector）**：新引入的超低延迟垃圾收集器，适合大内存、低延迟场景。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**ZGC**（可选）。
- **老年代垃圾回收器**：**G1**（默认），**ZGC**（可选）。
- **其他可选垃圾回收器**：CMS、Parallel Scavenge + Parallel Old。

### 5. JDK 12 (2019)
- **主要新特性**：
    - **Switch 表达式（预览）**：增强 switch 语句，可以返回值。
    - **Shenandoah GC**：另一种低延迟垃圾收集器，适合大内存场景。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**（可选），**ZGC**（可选）。
- **老年代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。

### 6. JDK 13 (2019)
- **主要新特性**：
    - **文本块（预览）**：引入多行字符串文本块。
    - **Switch 表达式正式版**：增强后的 switch 表达式支持返回值。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。

### 7. JDK 14 (2020)
- **主要新特性**：
    - **记录类（Record）**：简化类的定义，自动生成构造器、`equals`、`hashCode` 和 `toString`。
    - **改进的 NPE（NullPointerException）消息**：为 NPE 提供更详细的错误信息。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 8. JDK 15 (2020)
- **主要新特性**：
    - **封闭类（Sealed Classes）**：控制哪些类可以继承特定的类或接口。
    - **ZGC 生产就绪**：ZGC 退出实验阶段，进入正式生产使用。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 9. JDK 16 (2021)
- **主要新特性**：
    - **向量 API**：实验性 API，支持硬件加速的向量运算。
    - **强封闭类**：加强对 JDK 内部 API 的访问限制。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 10. JDK 17 (2021) (LTS)
- **主要新特性**：
    - **模式匹配 (instanceof)**：简化类型检查的代码。
    - **封闭类正式发布**。
    - **ZGC 性能优化**：支持更大堆内存，并优化性能。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 11. JDK 18 (2022)
- **主要新特性**：
    - **默认 UTF-8 编码**：JDK 默认字符集改为 UTF-8。
    - **简单 Web 服务器**：用于本地测试的 HTTP 文件服务器。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 12. JDK 19 (2022)
- **主要新特性**：
    - **虚拟线程（预览）**：简化并发编程，提供轻量级线程。
    - **结构化并发（预览）**：提高并发任务的管理。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 13. JDK 20 (2023)
- **主要新特性**：
    - **虚拟线程（第二次预览）**：虚拟线程的增强。
    - **记录模式（预览）**：模式匹配功能进一步增强。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**

### 13. JDK 20 (2023)
- **主要新特性**：
    - **虚拟线程（第二次预览）**：增强了虚拟线程的稳定性，简化了并发编程。
    - **记录模式（预览）**：扩展了模式匹配功能，允许在 `record` 类上使用模式匹配。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 14. JDK 21 (2023) (LTS)
- **主要新特性**：
    - **虚拟线程正式版**：虚拟线程成为正式功能，显著简化了并发编程的复杂性。
    - **模式匹配 (switch) 正式版**：`switch` 表达式和语句可以进行模式匹配，大大简化了类型检查和解构。
    - **字符串模板**：简化字符串的动态构建，增强可读性和安全性。
    - **ZGC**：进一步优化了 ZGC 的性能，支持更大的堆和更短的暂停时间。

- **虚拟机**：HotSpot
- **新生代垃圾回收器**：**G1**（默认），**Shenandoah**，**ZGC**。
- **老年代垃圾回收器**：**G1**，**Shenandoah**，**ZGC**。

### 小结
从 JDK 8 到 JDK 21，垃圾回收器经历了显著的发展，从并行垃圾收集器（Parallel GC）和 CMS，到更先进的 G1，最终引入了低延迟的 ZGC 和 Shenandoah。在新生代和老年代回收器上，JDK 8 及之前版本主要依赖 Parallel GC 组合，而 JDK 9 开始，**G1** 成为默认垃圾回收器，之后 ZGC 和 Shenandoah 成为低延迟场景的主要选择。

