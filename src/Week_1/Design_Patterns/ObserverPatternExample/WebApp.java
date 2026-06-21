package Week_1.Design_Patterns.ObserverPatternExample;

public class WebApp implements Observer {
    private final String url;

    public WebApp(String url) {
        this.url = url;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[Web App - " + url + "] Feed: Stock " + stockName + " price changed to $" + price);
    }
}
