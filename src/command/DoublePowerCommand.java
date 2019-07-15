package command;

public class DoublePowerCommand implements Command{
    private final Phone phone;
    public DoublePowerCommand (Phone phone) {
        this.phone = phone;
    }
    public void execute() {
        this.phone.doublePower();
    }
}
