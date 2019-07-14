package abstract_factory;

import abstract_factory.cpu.CPU;
import abstract_factory.gpu.GPU;
import abstract_factory.mainboard.MainBoard;
import abstract_factory.ram.RAM;

public class Hight implements Computer {
    public CPU getCPU() {
        return null;
    }

    public GPU getGPU() {
        return null;
    }

    public MainBoard getMainBoard() {
        return null;
    }

    public RAM getRAM() {
        return null;
    }
}
