package factory_method;

import simple_factory.CPU;
import simple_factory.R5_3600;

public class R5_3600Factory implements CPUFactoryMethod {
    public CPU createCPU() {
        return new R5_3600();
    }
}
