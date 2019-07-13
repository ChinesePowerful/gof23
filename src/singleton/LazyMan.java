package singleton;

public class LazyMan {

    private static LazyMan instance;

    private LazyMan() {}

    private static LazyMan getInstance() {
        if (null == instance) {
            return new LazyMan();
        }
        return instance;
    }

}
