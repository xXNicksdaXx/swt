package pruefung.probe;

public interface StockObserver {
    void priceUpdated(Stock stock, double newPrice);
}
