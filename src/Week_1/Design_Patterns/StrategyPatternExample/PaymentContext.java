package Week_1.Design_Patterns.StrategyPatternExample;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment strategy first.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
