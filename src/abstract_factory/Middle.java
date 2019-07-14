package abstract_factory;

import abstract_factory.cpu.CPU;
import abstract_factory.cpu.I5_9400F;
import abstract_factory.gpu.GPU;
import abstract_factory.gpu.GTX2060;
import abstract_factory.mainboard.B360M;
import abstract_factory.mainboard.MainBoard;
import abstract_factory.ram.DDR4_16G;
import abstract_factory.ram.RAM;

public class Middle implements Computer {
    public CPU getCPU() {
        return new I5_9400F();
    }

    public GPU getGPU() {
        return new GTX2060();
    }

    public MainBoard getMainBoard() {
        return new B360M();
    }

    public RAM getRAM() {
        return new DDR4_16G();
    }
}
