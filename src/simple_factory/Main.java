package simple_factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CPU cpu = null;

        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (str.equalsIgnoreCase("9400f")) {
            cpu = SimpleFactory.get9400F();
        } else if (str.equalsIgnoreCase("3700x")) {
            cpu = SimpleFactory.get3700X();
        }

        if (null != cpu) {
            cpu.printInformation();
        } else {
            System.out.println("init error");
        }
    }
}
