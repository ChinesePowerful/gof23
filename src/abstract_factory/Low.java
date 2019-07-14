package abstract_factory;

import abstract_factory.cpu.CPU;
import abstract_factory.cpu.I5_4590;
import abstract_factory.gpu.GPU;
import abstract_factory.gpu.GTX970;
import abstract_factory.mainboard.B85M;
import abstract_factory.mainboard.MainBoard;
import abstract_factory.ram.DDR3_8G;
import abstract_factory.ram.RAM;

public class Low implements Computer {

    public CPU getCPU() {
        return new I5_4590();
    }

    public GPU getGPU() {
        return new GTX970();
    }

    public MainBoard getMainBoard() {
        return new B85M();
    }

    public RAM getRAM() {
        return new DDR3_8G();
    }
}
