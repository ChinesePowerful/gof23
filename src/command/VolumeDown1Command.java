package command;

public class VolumeDown1Command implements Command {
    private final Phone phone;
    public VolumeDown1Command(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeDown1();
    }
}
