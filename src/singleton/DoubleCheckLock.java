package singleton;

public class DoubleCheckLock {

    private volatile static DoubleCheckLock instance;

    private DoubleCheckLock() {}

    public DoubleCheckLock getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckLock.class) {
                if (null == instance) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
