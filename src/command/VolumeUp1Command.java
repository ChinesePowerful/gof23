package command;

public class VolumeUp1Command implements Command {
    private final Phone phone;
    public VolumeUp1Command(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeUp1();
    }
}
