package chain_of_responsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
