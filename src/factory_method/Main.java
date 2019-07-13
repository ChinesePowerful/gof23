package factory_method;

import simple_factory.CPU;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CPU cpu = null;
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (str.equalsIgnoreCase("3600")) {
            cpu = new R5_3600Factory().createCPU();
        } else if (str.equalsIgnoreCase("3900x")) {
            cpu = new R5_3900XFactory().createCPU();
        }

        if (null != cpu) {
            cpu.printInformation();
        } else {
            System.out.println("init error");
        }
    }
}
