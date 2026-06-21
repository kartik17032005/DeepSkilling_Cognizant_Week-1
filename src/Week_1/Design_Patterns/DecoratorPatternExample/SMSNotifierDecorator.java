package Week_1.Design_Patterns.DecoratorPatternExample;

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
