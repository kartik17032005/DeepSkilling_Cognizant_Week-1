package Week_1.Design_Patterns.ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers;
    private final String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}
