package builder;

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
