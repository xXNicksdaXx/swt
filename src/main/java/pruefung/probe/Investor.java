package pruefung.probe;

import java.util.*;

public class Investor implements StockObserver {
    private final String name;
    private Map<Stock, Integer> deposit;

    public Investor(String name) {
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
        this.deposit = new HashMap<>();
    }

    public void priceUpdated(Stock stock, double newPrice) {
        if (stock == null) throw new NullPointerException("stock cannot be null!");

        System.out.println("Benachrichtigter Investor: " + name);
        System.out.println("Neuer Wert von " + stock + ": $" + newPrice);
    }

    public void buyShares(Stock stock, int numberOfShares) {
        if (stock == null) throw new NullPointerException("stock cannot be null!");
        if (numberOfShares <= 0) throw new IllegalArgumentException("numberOfShares must be above 0!");
        deposit.put(stock, numberOfShares);
        stock.addObserver(this);
    }

    public double valueOfDeposit() {
        double value = 0;
        for(Stock stock : deposit.keySet()){
            int number = deposit.get(stock);
            value += number * stock.getPrice();
        }
        return value;
    }
}