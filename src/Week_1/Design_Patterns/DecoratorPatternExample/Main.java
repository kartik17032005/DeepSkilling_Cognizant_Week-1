package Week_1.Design_Patterns.DecoratorPatternExample;

public class Main {
    static void main() {
        // Base notifier: Email only
        System.out.println("--- Scenario 1: Email Only ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System Update: Database backup complete.");
        System.out.println();

        // Email + SMS
        System.out.println("--- Scenario 2: Email + SMS ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("Security Alert: New login detected.");
        System.out.println();

        // Email + SMS + Slack
        System.out.println("--- Scenario 3: Email + SMS + Slack ---");
        Notifier emailSMSAndSlack = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()
                )
        );
        emailSMSAndSlack.send("Critical Alarm: CPU load is above 95%!");
    }
}
