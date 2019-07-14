package builder;

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
