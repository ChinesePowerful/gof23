package builder;

/**
 * 抽象出汉堡套餐制造流程
 */
public interface Builder {
    void builderHamburg();
    void builderSnack();
    void builderDrinks();
    HamburgSet getHamburgSet();
}
