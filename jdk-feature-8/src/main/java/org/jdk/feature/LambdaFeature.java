package org.jdk.feature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * - 定义: Lambda 表达式允许将行为作为参数传递，可以使代码更简洁。
 * - 语法: (parameters) -> expression
 * - 函数式接口: 只包含一个抽象方法的接口，Lambda 表达式可以与之一起使用。
 * - 常用接口: Predicate<T>、Function<T, R>、Consumer<T>、Supplier<T>。
 * - 优势: 简化代码、提高可维护性、支持并行处理。
 */
public class LambdaFeature {

    // 1. 定义员工类
    static class Employee {
        String name; // 姓名
        int age;     // 年龄

        Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + '}';
        }
    }

    // 2. 获取员工列表
    public List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 24),
                new Employee("Charlie", 28)
        );
    }

    // 3. 使用 Lambda 表达式处理员工列表
    public void processEmployees() {
        List<Employee> employees = getEmployees();

        // 4. 使用 Stream API 筛选和排序
        // 使用 Lambda 表达式筛选年龄大于 25 的员工
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.age > 25) // Lambda 表达式示例
                .sorted(Comparator.comparing(emp -> emp.name)) // Lambda 表达式示例
                .collect(Collectors.toList());

        // 5. 打印结果
        filteredEmployees.forEach(emp -> System.out.println(emp)); // 使用 Lambda 表达式打印
    }

    // 6. 主方法
    public static void main(String[] args) {
        LambdaFeature manager = new LambdaFeature();
        manager.processEmployees(); // 调用处理员工的方法
    }

}