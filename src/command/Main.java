package command;

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
