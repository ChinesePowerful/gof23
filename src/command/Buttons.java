package command;

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
