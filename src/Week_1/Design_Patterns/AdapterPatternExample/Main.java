package Week_1.Design_Patterns.AdapterPatternExample;

public class Main {
    static void main() {
        // Create the individual gateway instances (Adaptees)
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Wrap them in their respective adapters (Adapters)
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Test processPayment through the PaymentProcessor target interface
        System.out.println("Testing PayPal integration:");
        payPalProcessor.processPayment(150.50);
        System.out.println();

        System.out.println("Testing Stripe integration:");
        stripeProcessor.processPayment(275.00);
    }
}
