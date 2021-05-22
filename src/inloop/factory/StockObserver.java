package inloop.factory;

public interface StockObserver {
    public void onPartCountChanged(Part part, int count);
}
