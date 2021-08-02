package pruefung.probe;

import java.util.*;

public class Stock {
    private final String isin;
    private final String name;
    private double price;
    private Set<StockObserver> observers;

    public Stock(String isin, String name, double price) {
        if(isin == null) throw new NullPointerException("isin cannot be null!");
        if(isin.equals("")) throw new IllegalArgumentException("isin cannot be empty!");
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        if(price < 0) throw new IllegalArgumentException("price cannot be negative!");

        this.isin = isin;
        this.name = name;
        this.price = price;
        this.observers = new HashSet<>();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice < 0) throw new IllegalArgumentException("newPrice cannot be negative!");
        this.price = newPrice;
        notifyObservers(newPrice);
    }

    private void notifyObservers(double newPrice) {
        for(StockObserver observer : observers){
            observer.priceUpdated(this, newPrice);
        }
    }

    public void addObserver(StockObserver observer){
        if (observer == null) throw new NullPointerException("observer cannot be null!");
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer){
        if (observer == null) throw new NullPointerException("observer cannot be null!");
        observers.remove(observer);
    }

    public String getIsin() {
        return isin;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " (" + isin + ")";
    }
}