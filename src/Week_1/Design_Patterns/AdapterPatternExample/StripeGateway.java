package Week_1.Design_Patterns.AdapterPatternExample;

public class StripeGateway {
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " using Stripe Gateway.");
    }
}
