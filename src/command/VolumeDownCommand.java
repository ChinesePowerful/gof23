package command;

public class VolumeDownCommand implements Command{
    private final Phone phone;
    public VolumeDownCommand(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeDown();
    }
}
