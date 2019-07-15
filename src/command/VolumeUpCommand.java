package command;

public class VolumeUpCommand implements Command{
    private final Phone phone;
    public VolumeUpCommand(Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.volumeUp();
    }
}
