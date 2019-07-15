26.代理模式（Proxy）
=====

简介
----

### 意图
- 给目标对象提供一个代理对象，并且由代理对象控制对目标对象的引用

### 主要解决
- 直接访问对象时带来的问题

### 何时使用
- 想在访问一个类时做一些控制

### 注意
- 代理模式可能会造成请求的处理速度变慢

实现
----

### 实例
- 你，是一个明星，你需要开演唱会来提高自己的名气。但你，开演唱会是很繁琐的一件事情，需要处理很多唱歌以外的事情，例如：
    - 与演出机构商谈
    - 筹备演唱会具体事项
    - 进行演唱会的宣传
    - 寻找正规的票务公司售票
    - 演出完成后的事项处理和演出回顾
- 所以，你需要一个经纪人来代理你处理这些，除了唱歌之外的事情

### 接口
```java
public interface VocalConcert {
//    开始演唱会
    void todo();
}
```

### 目标对象
```java
public class Star implements VocalConcert{

    private String starName;

    public Star(String starName) {
        this.starName = starName;
    }

    public void todo() {
        System.out.println(starName + " 唱歌");
    }
}
```

### 代理对象
```java
public class Broker implements VocalConcert {

    private String brokerName;

    private Star star;

    public Broker(String brokerName, Star star) {
        this.brokerName = brokerName;
        this.star = star;
    }

    //    进行演唱会除了唱歌以外的各个事项的处理，等到演唱会开始时告知明星上台唱歌即可
    public void todo() {
        before();
        this.star.todo();
        after();
    }

    private void before() {
        System.out.println(brokerName + " 与演出机构商谈");
        System.out.println(brokerName + " 筹备演唱会具体事项");
        System.out.println(brokerName + " 进行演唱会的宣传");
        System.out.println(brokerName + " 寻找正规的票务公司售票");
    }

    private void after() {
        System.out.println(brokerName + " 演出完成后的事项处理和演出回顾");
    }
}
```

### 调用类

```java
public class Main {
    public static void main(String[] args) {
        Star star = new Star("周杰伦");
        Broker broker = new Broker("杨峻荣", star);
//        由经纪人发起演唱会
        broker.todo();
    }
}
```