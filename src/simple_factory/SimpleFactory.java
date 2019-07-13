package simple_factory;

public class SimpleFactory {

    public static CPU get9100F() {
        return new I3_9100F();
    }

    public static CPU get9400F() {
        return new I5_9400F();
    }

    public static CPU get9700K() {
        return new I7_9700K();
    }

    public static CPU get9900K() {
        return new I9_9900K();
    }

    public static CPU get3600() {
        return new R5_3600();
    }

    public static CPU get3700X() {
        return new R5_3700X();
    }

}
