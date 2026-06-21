package Week_1.Design_Patterns.ObserverPatternExample;

public class Main {
    static void main() {
        // Create stock market subject
        StockMarket appleStock = new StockMarket("AAPL", 175.50);

        // Create concrete observers
        Observer mobileApp1 = new MobileApp("TradeMaster");
        Observer mobileApp2 = new MobileApp("StockWatch");
        Observer webPortal = new WebApp("https://finance.example.com");

        // Register observers
        System.out.println("--- Registering Observers ---");
        appleStock.registerObserver(mobileApp1);
        appleStock.registerObserver(mobileApp2);
        appleStock.registerObserver(webPortal);

        // Modify stock price
        System.out.println("\n--- Updating Stock Price to $178.20 ---");
        appleStock.setPrice(178.20);

        // Deregister one observer
        System.out.println("\n--- Deregistering StockWatch Mobile App ---");
        appleStock.deregisterObserver(mobileApp2);

        // Modify stock price again
        System.out.println("\n--- Updating Stock Price to $180.00 ---");
        appleStock.setPrice(180.00);
    }
}
