package Week_1.Design_Patterns.CommandPatternExample;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            System.out.println("No command set on the remote control.");
            return;
        }
        command.execute();
    }
}
