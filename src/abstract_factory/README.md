4.抽象工厂模式（Abstract Factory）
=====

简介
----

### 意图
- 调用者与创建者解藕，调用者不需要知道创建细节

### 主要解决
- 调用者实例化对象时的耦合问题

### 何时使用
- 需要同时创建一批比较固定的、彼此之间有关联产品时

### 注意
- 抽象工厂很难支持添加新种类产品，因为抽象工厂中已经确定了被创建的产品族中包含的产品

### 简单工厂和工厂方法的问题
- 对于需要同时创建一批比较固定的、彼此之间有关联产品时，简单工厂和工厂方法就不适用了，它们没有解决对象之间互相依赖匹配的问题

### 解决方案
- 将需要同时创建的产品族

实现
----

### 实例
- 一台电脑由很多类硬件组成，比如 CPU、GPU、主板、内存 等，它们每一类都有很多不同参数的产品。这些同一类但是不同参数的产品都属于 同一个产品等级结构，例如：
    - CPU：I5-4590、I5-9400F、R5-3900X
    - GPU：GTX-970、GTX-2060、GTX-2080TI
    - 主板：B85M、B360M、X570
    - 内存：DDR3-8G、DDR4-16G、DDR4-32G
- 可以根据这些硬件搭配成不同规格的电脑，它们就是不同的产品族，它们基本是已经固定的，例如：
    - 低配主机：I5-4590 + GTX-970 + B85M + DDR3-8G
    - 中配主机：I5-9400F + GTX-2060 + B360M + DDR4-16G
    - 高配主机：R5-3900X + GTX-2080TI + X570 + DDR4-32G
- 流水线工人只需要获取已经搭配好的硬件进行组装即可，并不需要知道这些硬件搭配起来是否合适

### 接口

CPU 接口
```java
public interface CPU {
    void printInfo();
}
```
GPU 接口
```java
public interface GPU {
    void printInfo();
}
```
主板 接口
```java
public interface MainBoard {
    void printInfo();
}

```
内存 接口
```java
public interface RAM {
    void printInfo();
}
```

### 实现类
CPU 实现类
```java
public class I5_4590 implements CPU {
    public void printInfo() {
        System.out.println("I'm i5-4590");
    }
}
```
```java
public class I5_9400F implements CPU {
    public void printInfo() {
        System.out.println("I'm i5-9400f");
    }
}
```
```java
public class R5_3900X implements CPU {
    public void printInfo() {
        System.out.println("I'm r5-3900x");
    }
}
```
GPU 实现类
```java
public class GTX970 implements GPU {
    public void printInfo() {
        System.out.println("I'm gtx-970");
    }
}
```
```java
public class GTX2060 implements GPU {
    public void printInfo() {
        System.out.println("I'm gtx-2060");
    }
}
```
```java
public class GTX2080TI implements GPU {
    public void printInfo() {
        System.out.println("I'm gtx-2080ti");
    }
}
```
主板 实现类
```java
public class B85M implements MainBoard {
    public void printInfo() {
        System.out.println("I'm b85m");
    }
}
```
```java
public class B360M implements MainBoard {
    public void printInfo() {
        System.out.println("I'm b360m");
    }
}
```
```java
public class X570 implements MainBoard {
    public void printInfo() {
        System.out.println("I'm x570");
    }
}
```
内存 实现类
```java
public class DDR3_8G implements RAM {
    public void printInfo() {
        System.out.println("I'm ddr3-8g");
    }
}
```
```java
public class DDR4_16G implements RAM {
    public void printInfo() {
        System.out.println("I'm ddr4-16g");
    }
}
```
```java
public class DDR4_32G implements RAM {
    public void printInfo() {
        System.out.println("I'm ddr4-32g");
    }
}
```