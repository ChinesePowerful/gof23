package builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
