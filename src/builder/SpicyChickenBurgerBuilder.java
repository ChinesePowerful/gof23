package builder;

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
