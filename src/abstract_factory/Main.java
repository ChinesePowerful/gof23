package abstract_factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Computer computer = null;

//        输入字符串选择电脑配置
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();

        if (str.equalsIgnoreCase("high")) {
            computer = new High();
        } else if (str.equalsIgnoreCase("middle")) {
            computer = new Middle();
        } else if (str.equalsIgnoreCase("low")) {
            computer = new Low();
        } else {
            System.out.println("init error");
            return;
        }

//        打印电脑配置信息
        computer.getCPU().printInfo();
        computer.getGPU().printInfo();
        computer.getMainBoard().printInfo();
        computer.getRAM().printInfo();
    }
}
