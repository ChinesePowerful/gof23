5.建造者模式（Builder）
=====

简介
----

### 意图
- 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示

### 主要解决
- 解决调用者需要根据条件获取【同样构建过程但是构建结果不一样的实例】

### 何时使用
- 构建的复杂对象内部，部分固定不变，部分经常变化

### 注意
- 建造者模式更注重实例化对象内部的构造顺序

实现
----

### 实例
- 麦当劳推出了很多汉堡套餐，它们都由【汉堡】【小吃】【饮料】组成，比如：
    - 麦辣鸡腿堡套餐【大】：麦辣鸡腿堡 + 大薯条 + 大可乐
    - 巨无霸套餐【自定义】：巨无霸汉堡 + 麦辣鸡翅 + 零度可乐
    - 不素之霸套餐：不素之霸汉堡 + 中薯条 + 中可乐
- 你，是一个肥仔。你去麦当劳点餐，只需要告诉服务员你需要什么套餐，然后排队取餐（取餐时可以清点套餐内容）即可，不需要关注套餐是怎么制作的

### 汉堡套餐类
```java
public class HamburgSet {
    private String hamburg;
    private String snack;
    private String drinks;

    public String getHamburg() {
        return hamburg;
    }

    public void setHamburg(String hamburg) {
        this.hamburg = hamburg;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }
}
```

### 定义汉堡制造过程接口
```java
/**
 * 抽象出汉堡套餐制造流程
 */
public interface Builder {
    void builderHamburg();
    void builderSnack();
    void builderDrinks();
    HamburgSet getHamburgSet();
}
```

### 服务员通知制造汉堡套餐
```java
public class Waiter {
    /**
     * 服务员告知后厨需要制作并配送汉堡套餐
     * 可调整【汉堡】【小吃】【饮料】的制作顺序
     * @param builder 需要建造的套餐类
     */
    public void makeHamburgSet(Builder builder) {
        builder.builderHamburg();
        builder.builderSnack();
        builder.builderDrinks();
    }
}
```

### 实现汉堡套餐制作类
麦辣鸡腿堡套餐
```java
public class SpicyChickenBurgerBuilder implements Builder {

    private HamburgSet hamburgSet = new HamburgSet();

    public void builderHamburg() {
        hamburgSet.setHamburg("麦辣鸡腿堡");
    }

    public void builderSnack() {
        hamburgSet.setSnack("大薯条");
    }

    public void builderDrinks() {
        hamburgSet.setDrinks("大可乐");
    }

    public HamburgSet getHamburgSet() {
        return hamburgSet;
    }
}
```
不素之霸套餐
```java
public class NoVegetablesBuilder implements Builder {

    private HamburgSet hamburgSet = new HamburgSet();

    public void builderHamburg() {
        hamburgSet.setHamburg("不素之霸汉堡");
    }

    public void builderSnack() {
        hamburgSet.setSnack("中薯条");
    }

    public void builderDrinks() {
        hamburgSet.setDrinks("中可乐");
    }

    public HamburgSet getHamburgSet() {
        return hamburgSet;
    }
}
```
巨无霸套餐
```java

public class BigMacBuilder implements Builder{

    private HamburgSet hamburgSet = new HamburgSet();

    public void builderHamburg() {
        hamburgSet.setHamburg("巨无霸汉堡");
    }

    public void builderSnack() {
        hamburgSet.setSnack("麦辣鸡翅");
    }

    public void builderDrinks() {
        hamburgSet.setDrinks("零度可乐");
    }

    public HamburgSet getHamburgSet() {
        return hamburgSet;
    }
}
```

### 调用类
```java
public class Main {
    public static void main(String[] args) throws IOException {
//        服务员
        Waiter waiter = new Waiter();
//        建造者
        Builder builder;

        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
//        开始点餐
        if (str.equals("不素之霸套餐")) {
            builder = new NoVegetablesBuilder();
        } else if (str.equals("巨无霸套餐")) {
            builder = new BigMacBuilder();
        } else if (str.equals("麦辣鸡腿堡套餐")) {
            builder = new SpicyChickenBurgerBuilder();
        } else {
            System.out.println("init error");
            return;
        }
//        开始制造
        waiter.makeHamburgSet(builder);
//        获取汉堡套餐
        HamburgSet hamburgSet = builder.getHamburgSet();
//        清点
        System.out.println(
                hamburgSet.getHamburg() + ", " +
                hamburgSet.getSnack() + "," +
                hamburgSet.getDrinks());
    }
}
```