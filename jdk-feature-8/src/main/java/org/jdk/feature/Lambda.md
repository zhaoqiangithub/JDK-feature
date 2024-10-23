Java 8 引入了 Lambda 表达式，这是一种可以简化函数式接口实现的语法特性。Lambda 表达式使得代码更加简洁和易读，并且支持编写更加灵活的函数式编程风格。下面详细介绍 Java 8 中的 Lambda 表达式的概念、语法和使用方法。

### Lambda 表达式的概念

Lambda 表达式是一种匿名函数，它可以作为方法的参数传递，也可以作为一个方法的返回值。Lambda 表达式的主要特点是它可以“捕获”其作用域内的局部变量，并在闭包中使用这些变量。

### Lambda 表达式的语法

Lambda 表达式的语法格式如下：

```java
(parameters) -> expression
```

或者

```java
(parameters) -> {
    statements;
}
```

其中：

- **parameters**：Lambda 表达式的参数列表。
- **expression** 或 **statements**：Lambda 表达式主体，可以是一条表达式或一组语句。

如果参数列表只有一个参数，则可以省略括号，例如：

```java
(parameter) -> expression
```

可以写作：

```java
parameter -> expression
```

### 使用 Lambda 表达式的前提

使用 Lambda 表达式的一个重要前提是目标接口必须是一个 **函数式接口**（Functional Interface）。所谓函数式接口，是指一个接口中只有一个抽象方法的接口。Java 8 提供了一些内置的函数式接口，如 `Runnable`、`Predicate<T>`、`Function<T, R>` 等。

### Lambda 表达式的使用示例

#### 示例 1：使用 Lambda 表达式替代匿名内部类

假设我们有一个接口 `MyFunctionalInterface`：

```java
interface MyFunctionalInterface {
    void doSomething();
}
```

使用传统匿名内部类的方式：

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello from anonymous inner class!");
    }
}).start();
```

使用 Lambda 表达式：

```java
new Thread(() -> System.out.println("Hello from lambda expression!")).start();
```

#### 示例 2：使用 Lambda 表达式实现函数式接口

假设我们有一个函数式接口 `MyFunction`：

```java
@FunctionalInterface
interface MyFunction<T, R> {
    R apply(T t);
}
```

使用 Lambda 表达式实现该接口：

```java
MyFunction<Integer, Integer> square = (Integer x) -> x * x;
System.out.println(square.apply(5)); // 输出 25
```

#### 示例 3：使用 Lambda 表达式排序集合

假设我们有一个 `Person` 类：

```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

使用 Lambda 表达式对 `List<Person>` 进行排序：

```java
List<Person> people = Arrays.asList(
    new Person("Alice", 30),
    new Person("Bob", 25),
    new Person("Charlie", 35)
);

// 按年龄排序
people.sort((p1, p2) -> p1.getAge() - p2.getAge());
people.forEach(person -> System.out.println(person.getName() + ": " + person.getAge()));
```

### Lambda 表达式的注意事项

1. **参数类型推断**：
    - Java 8 可以通过上下文推断 Lambda 表达式的参数类型，因此在某些情况下可以省略类型声明。

2. **局部变量访问**：
    - Lambda 表达式可以访问外部作用域中的局部变量，但这些变量必须是最终的（final）或者是实际上不可修改的（effectively final）。

3. **多行语句**：
    - 如果 Lambda 表达式主体包含多条语句，则必须使用花括号 `{}` 包裹起来。

### 总结

Lambda 表达式是 Java 8 中引入的一项重要特性，它使得代码更加简洁、易读，并支持函数式编程风格。通过使用 Lambda 表达式，可以更加方便地实现函数式接口，并进行诸如排序、过滤等操作。理解 Lambda 表达式的概念和语法对于充分利用 Java 8 的新特性非常重要。