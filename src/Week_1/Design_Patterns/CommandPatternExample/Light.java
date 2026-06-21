package Week_1.Design_Patterns.CommandPatternExample;

public class Light {
    private final String room;

    public Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        System.out.println("The " + room + " light is ON.");
    }

    public void turnOff() {
        System.out.println("The " + room + " light is OFF.");
    }
}
