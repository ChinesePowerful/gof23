package singleton;

public class HungryMan {

    private static HungryMan instance = new HungryMan();

    private HungryMan() {}

    public HungryMan getInstance() {
        return instance;
    }

}
