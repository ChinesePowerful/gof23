package command;

public class Power1Command implements Command {
    private final Phone phone;
    public Power1Command (Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.power1();
    }
}
