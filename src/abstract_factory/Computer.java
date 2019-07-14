package abstract_factory;

import abstract_factory.cpu.CPU;
import abstract_factory.gpu.GPU;
import abstract_factory.mainboard.MainBoard;
import abstract_factory.ram.RAM;

/**
 * 抽象产品工厂，定义了同一个产品族生产产品的行为
 */
public interface Computer {
    CPU getCPU();
    GPU getGPU();
    MainBoard getMainBoard();
    RAM getRAM();
}
