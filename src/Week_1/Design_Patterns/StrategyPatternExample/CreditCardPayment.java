package Week_1.Design_Patterns.StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardHolderName;
    private final String cardNumber;
    private final String cvv;
    private final String expirationDate;

    public CreditCardPayment(String cardHolderName, String cardNumber, String cvv, String expirationDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending in " + 
                           cardNumber.substring(cardNumber.length() - 4));
    }
}
