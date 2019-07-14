package abstract_factory;

import abstract_factory.cpu.CPU;
import abstract_factory.cpu.R5_3900X;
import abstract_factory.gpu.GPU;
import abstract_factory.gpu.GTX2080TI;
import abstract_factory.mainboard.MainBoard;
import abstract_factory.mainboard.X570;
import abstract_factory.ram.DDR4_32G;
import abstract_factory.ram.RAM;

public class High implements Computer {
    public CPU getCPU() {
        return new R5_3900X();
    }

    public GPU getGPU() {
        return new GTX2080TI();
    }

    public MainBoard getMainBoard() {
        return new X570();
    }

    public RAM getRAM() {
        return new DDR4_32G();
    }
}
