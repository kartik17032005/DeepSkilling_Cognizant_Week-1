package Week_1.Design_Patterns.CommandPatternExample;

public class Main {
    static void main() {
        // Create Receiver
        Light livingRoomLight = new Light("Living Room");

        // Create Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create Invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light ON
        System.out.println("--- Pressing ON button on remote control ---");
        remote.setCommand(lightOn);
        remote.pressButton();
        System.out.println();

        // Turn the light OFF
        System.out.println("--- Pressing OFF button on remote control ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
