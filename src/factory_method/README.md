3.工厂方法模式（Factory Method）
=====

简介
----

### 意图
- 调用者与创建者解藕，调用者不需要知道创建细节

### 主要解决
- 调用者实例化对象时的耦合问题

### 何时使用
- 调用者在不同条件会创建不同的实例时
- 工厂中的产品在不断变化时

### 注意
- 添加新的产品时，除了需要添加新的产品类外，还需要提供与之对应的具体工厂类，类的个数会成对增加，增加了项目的复杂度
- 一个工厂只能创建一个具体的产品


### 简单工厂的问题
- 工厂集中了所有的产品，一但这个工厂不能工作，调用者就会收到影响
- 一但需要添加新的产品就不得不修改工厂类的逻辑，会造成工厂逻辑过于复杂

### 解决方法
- 将类的实例化（具体产品的创建）延迟到具体工厂类中完成

实现
----

### 实例
- CPU 工厂已经将工厂内所有的空间都物尽其用了，割分了总共六个车间来生产六款不同型号的 CPU 了
- 此时，根据工厂母公司的要求，工厂需要再生产一款新的 CPU。但是，工厂的空间已经规定好了，在大刀阔斧的修改会造成很大的损失
- 所以，开辟一家新的工厂用于生产新款 CPU 即可

### 接口
```java
public interface CPUFactoryMethod {
    CPU createCPU();
}
```
### 新的产品
```java
public class R5_3900X implements CPU {
    public void printInformation() {
        System.out.println("我是 r5-3900x");
    }
}
```

### 实现类
```java
public class R5_3900XFactory implements CPUFactoryMethod {
    public CPU createCPU() {
        return new R5_3900X();
    }
}
```

### 调用类
```java
public class Main {
    public static void main(String[] args) throws IOException {
        CPU cpu = null;
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (str.equalsIgnoreCase("3600")) {
            cpu = new R5_3600Factory().createCPU();
        } else if (str.equalsIgnoreCase("3900x")) {
            cpu = new R5_3900XFactory().createCPU();
        }

        if (null != cpu) {
            cpu.printInformation();
        } else {
            System.out.println("init error");
        }
    }
}
```