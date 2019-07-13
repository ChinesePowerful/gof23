package singleton;

public class SingleCase {

    private SingleCase() {}

    private static class StaticInsideClass {
        public static final SingleCase INSTANCE = new SingleCase();
    }

    public static SingleCase getInstance() {
        return StaticInsideClass.INSTANCE;
    }

}
