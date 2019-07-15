7.责任链模式（Chain of Responsibility）
=====

简介
----

### 意图
- 使多个对象都有处理请求的机会，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象串成一条链，并沿着这条链一直传递该请求，直到有对象处理它为止

### 主要解决
- 职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了

### 何时使用
- 在处理消息或者请求需要拦截或者过滤的时候可以使用到

### 注意
- 使用责任链模式系统的性能会受到一定的影响

实现
----

### 实例
- 你，正在网上冲浪，很嗨。但是，你输入的网址不是所有的都能够访问的，他们其中有一些会有出现神秘的 404 代码
- 假设你输入的网址是过滤后才允许访问的，那么我们来实现那个过滤器吧
- 这里只是假设，不保证所有请求过滤后都能得到处理

### 过滤器
```java
/**
 * 过滤器
 * filterWebName 会被拦截的网址
 */
public class Filter {
    private String filterWebName;

    public Filter(String filterWebName) {
        this.filterWebName = filterWebName;
    }

    /**
     * 过滤方法，如果网址会被拦截则返回 true
     * @param webName 网址
     * @return true or false
     */
    public boolean doFilter(String webName) {
        if (webName.equalsIgnoreCase(this.filterWebName)) {
            return true;
        } else {
            return false;
        }
    }
}
```

### 处理器
```java
public class Handler {

    private int position = 0;
    private int filterNumber = 0;

//    用于存放所有过滤器
    private List<Filter> filterList = new ArrayList<>();
//    添加过滤器
    public void addFilter(Filter filter) {
        this.filterList.add(filter);
        this.filterNumber++;
    }

    /**
     * 处理请求
     * @param webName 网址
     */
    public void handlerRequest(String webName) {
        if (this.position < this.filterNumber) {
            if (this.filterList.get(this.position++).doFilter(webName)) {
                System.out.println("神秘 404 代码");
                this.position = 0;
                return;
            }
            this.handlerRequest(webName);
        } else {
            System.out.println(webName + " 可以访问");
            this.position = 0;
        }
    }

}
```

### 调用类
```java
public class Main {
    public static void main(String[] args) throws IOException {
//        创建处理器
        Handler handler = new Handler();
//        添加过滤器
        handler.addFilter(new Filter("www.youtube.com"));
        handler.addFilter(new Filter("www.facebook.com"));
        handler.addFilter(new Filter("www.twitter.com"));

        System.out.println("请输入访问链接：");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        while (!str.equalsIgnoreCase("bye")) {
            handler.handlerRequest(str);
            System.out.println("请输入访问链接：");
            str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
    }
}
```