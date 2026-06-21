package Week_1.Design_Patterns.DecoratorPatternExample;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}
