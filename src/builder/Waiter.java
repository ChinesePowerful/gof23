package builder;

public class Waiter {
    /**
     * 服务员告知后厨需要制作汉堡套餐
     * 可调整【汉堡】【小吃】【饮料】的制作顺序
     * @param builder 需要建造的套餐类
     */
    public void makeHamburgSet(Builder builder) {
        builder.builderHamburg();
        builder.builderSnack();
        builder.builderDrinks();
    }
}
