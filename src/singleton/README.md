1.单例模式（Singleton）
---
### 简介

#### 意图
- 保证一个类仅有一个实例，并提供一个访问它的全局访问点

#### 主要解决
- 一个全局使用的类频繁的创建与销毁

#### 何时使用
- 需要控制实例的数量，节省系统资源的时候

#### 注意：
- 单例类只能有一个实例
- 单例类必须自己创建自己的唯一实例
- 单例类必须给所有其他对象提供这一实例

懒汉式 - 线程不安全
----

在以下实现中，私有静态变量 instance 被延迟实例化。
这样做的好处是，如果没有用到该类，那么就不会实例化 instance，从而节省资源。

```java
public class LazyMan {

    private static LazyMan instance;

    private LazyMan() {}

    private static LazyMan getInstance() {
        if (null == instance) {
            return new LazyMan();
        }
        return instance;
    }

}
```

饿汉式 - 线程安全
----

直接实例化 instance 保证了线程安全，但是直接实例化的方式丢失了延迟实例化带来的节约资源的好处

```java
public class HungryMan {

    private static HungryMan instance = new HungryMan();

    private HungryMan() {}

    public HungryMan getInstance() {
        return instance;
    }

}
```

枚举
----