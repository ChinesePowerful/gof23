package factory_method;

import simple_factory.CPU;

public class R5_3900XFactory implements CPUFactoryMethod {
    public CPU createCPU() {
        return new R5_3900X();
    }
}
