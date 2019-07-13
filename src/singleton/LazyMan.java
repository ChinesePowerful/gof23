package singleton;

public class LazyMan {

    private static LazyMan instance;

    private LazyMan() {}

    public static LazyMan getInstance() {
        if (null == instance) {
            instance = new LazyMan();
        }
        return instance;
    }

}
