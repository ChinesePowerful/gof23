8.命令模式（Command）
=====

简介
----

### 意图
- 将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化

### 主要解决
- 发送请求者和处理请求这之间的耦合关系

### 何时使用
- 需要使用命令来参数化其他对象时
- 需要对发送请求者和请求处理者进行解藕时

### 注意
- 使用命令模式可能会导致项目内会有过多的具体命令类

实现
----

### 实例
- 使用命令模式需要有三个角色
    - Command：命令
    - Received：命令接收者，真正执行命令的角色
    - Invoker：命令调用者，接收命令后进行调用的角色
    - Client：客户端，设置和发送命令的角色
- 你，有一部手机，它的物理按键一共有 3 个，你需要给他设置编号和命令，例如：
    - 增加一格音量
        - 命令：VolumeUp
        - 编号：0
    - 长按增加音量
        - 命令：VolumeUp
        - 编号：1

### 抽象出命令接口
```java
public interface Command {
    void execute();
}
```

### 手机类（Received）
```java
public class Phone {

    private static final int VOLUME_MAX = 16;
    private static final int VOLUME_MIN = 0;

    private int volume = 8;

    private boolean screen = false;

    public void volumeUp1() {
        if (this.volume >= VOLUME_MAX) {
            System.out.println("音量已经最大了！音量：" + this.volume);
            return;
        }
        this.volume++;
        System.out.println("单击音量增加按键～音量" + this.volume);
    }

    public void volumeUp() {
        if (this.volume >= VOLUME_MAX) {
            System.out.println("音量已经最大了！音量：" + this.volume);
            return;
        }
        this.volume = VOLUME_MAX;
        System.out.println("长按音量增加！音量：" + this.volume);
    }

    public void volumeDown1() {
        if (this.volume <= VOLUME_MIN) {
            System.out.println("音量已经最小了！音量：" + this.volume);
            return;
        }
        this.volume--;
        System.out.println("单击音量减少按键～音量：" + this.volume);
    }

    public void volumeDown() {
        if (this.volume <= VOLUME_MIN) {
            System.out.println("音量已经最小了！音量：" + this.volume);
            return;
        }
        this.volume = VOLUME_MIN;
        System.out.println("长按音量减少！音量：" + this.volume);
    }

    public void power1() {
        if (this.screen) {
            System.out.println("单击电源按键：正在熄灭屏幕～");
            this.screen = false;
        } else {
            System.out.println("单击电源按键：正在点亮屏幕～");
            this.screen = true;
        }
    }

    public void power() {
        System.out.println("长按电源按键～呼叫出 Siri～");
    }

    public void doublePower() {
        System.out.println("双击电源按键～打开了 Apple Pay～");
    }

}
```

### 实现命令接口
```java
public class Power1Command implements Command {
    private final Phone phone;
    public Power1Command (Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.power1();
    }
}
```
```java
public class PowerCommand implements Command{
    private final Phone phone;
    public PowerCommand (Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.power();
    }
}
```
```java
public class DoublePowerCommand implements Command{
    private final Phone phone;
    public DoublePowerCommand (Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.doublePower();
    }
}
```
```java
public class VolumeDown1Command implements Command {
    private final Phone phone;
    public VolumeDown1Command(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeDown1();
    }
}
```
```java
public class VolumeDownCommand implements Command{
    private final Phone phone;
    public VolumeDownCommand(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeDown();
    }
}
```
```java
public class VolumeUp1Command implements Command {
    private final Phone phone;
    public VolumeUp1Command(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeUp1();
    }
}
```
```java
public class VolumeUpCommand implements Command{
    private final Phone phone;
    public VolumeUpCommand(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeUp();
    }
}
```

### 按键类（Invoker）
```java
public class Buttons {

    private static final int COMMAND_SIZE = 10;

    private  Command[] powers;
    private  Command[] volumeUps;
    private  Command[] volumeDowns;

    public Buttons() {
        this.powers =  new Command[COMMAND_SIZE];
        this.volumeUps = new Command[COMMAND_SIZE];
        this.volumeDowns = new Command[COMMAND_SIZE];
    }

//    设计按键中每个编号执行的命令

    public void setPower(Command command, int number) {
        if (number > COMMAND_SIZE) return;
        this.powers[number] = command;
    }

    public void setVolumeUp(Command command, int number) {
        this.volumeUps[number] = command;
    }

    public void setVolumeDown(Command command, int number) {
        this.volumeDowns[number] = command;
    }

//    根据编号执行对应按键的对应命令

    public void onPower(int number) {
        this.powers[number].execute();
    }

    public void onVolumeUp(int number) {
        this.volumeUps[number].execute();
    }

    public void onVolumeDown(int number) {
        this.volumeDowns[number].execute();
    }

}
```

### 调用类
```java
public class Main {
    public static void main(String[] args) {
//        创建手机
        Phone phone = new Phone();
//        创建手机上按键
        Buttons buttons = new Buttons();
//        设置按键编号对应的命令

//        1.单击电源 2.长按电源 3.双击电源
        buttons.setPower(new Power1Command(phone), 1);
        buttons.setPower(new Power1Command(phone), 2);
        buttons.setPower(new Power1Command(phone), 3);
//        1.单击音量+ 2.长按音量+
        buttons.setVolumeUp(new VolumeUp1Command(phone), 1);
        buttons.setVolumeUp(new VolumeUpCommand(phone), 2);
//        1.单击音量- 2.长按音量-
        buttons.setVolumeDown(new VolumeDown1Command(phone), 1);
        buttons.setVolumeDown(new VolumeDownCommand(phone), 2);

//        测试
        buttons.onPower(1);
        buttons.onPower(2);
        buttons.onPower(3);

        buttons.onVolumeUp(1);
        buttons.onVolumeUp(1);
        buttons.onVolumeUp(1);
        buttons.onVolumeUp(2);

        buttons.onVolumeDown(1);
        buttons.onVolumeDown(1);
        buttons.onVolumeDown(1);
        buttons.onVolumeDown(2);
    }
}
```