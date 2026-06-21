package Week_1.Design_Patterns.StrategyPatternExample;

public class Main {
    static void main() {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        System.out.println("--- Selecting Credit Card Payment Strategy ---");
        PaymentStrategy creditCard = new CreditCardPayment(
                "John Doe", "1234567890123456", "123", "12/28"
        );
        context.setPaymentStrategy(creditCard);
        context.executePayment(500.25);
        System.out.println();

        // Pay using PayPal
        System.out.println("--- Selecting PayPal Payment Strategy ---");
        PaymentStrategy payPal = new PayPalPayment(
                "john.doe@example.com", "mypassword"
        );
        context.setPaymentStrategy(payPal);
        context.executePayment(120.80);
    }
}
