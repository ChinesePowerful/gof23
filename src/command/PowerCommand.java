package command;

public class PowerCommand implements Command{
    private final Phone phone;
    public PowerCommand (Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.power();
    }
}
