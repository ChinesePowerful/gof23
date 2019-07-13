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
这样做的好处是，如果没有用到该类，那么就不会实例化 instance，从而节省资源

```java
public class LazyMan {

    private static LazyMan instance;

    private LazyMan() {}

    public static LazyMan getInstance() {
        if (null == instance) {
            instance = new LazyMan();
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

双重检测锁 - 线程安全
----
先判断 instance 是否已经被实例化，如果没有实例化，则进入加锁语句块再次判断 instance 是否已经被实例化，若没有被实例化则进行实例化

```java
public class DoubleCheckLock {

    private volatile static DoubleCheckLock instance;

    private DoubleCheckLock() {}

    public DoubleCheckLock getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckLock.class) {
                if (null == instance) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
```

静态内部类 - 线程安全
----
当 SingleCase 被加载时，静态内部类 StaticInsideClass 并没有被加载进内存。只有调用 getInstance() 方法时才会实例化 StaticInsideClass 内的 INSTANCE，并且 JVM 能确保 INSTANCE 只被实例化一次

```java
public class SingleCase {

    private SingleCase() {}

    private static class StaticInsideClass {
        public static final SingleCase INSTANCE = new SingleCase();
    }

    public static SingleCase getInstance() {
        return StaticInsideClass.INSTANCE;
    }

}
```

枚举
----
这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化

```java
public enum  EnumImplSingleton {

    INSTANCE;

    private Object attributeName;

    public Object getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(Object attributeName) {
        this.attributeName = attributeName;
    }
}
```