package inloop.factory;

public class Purchasing implements StockObserver{
    private ReceivingStock receivingStock;

    public Purchasing(ReceivingStock receivingStock){
        this.receivingStock = receivingStock;
    }

    public void buy(Part part, int count){
        return;
    }

    public ReceivingStock getStock() {
        return receivingStock;
    }

    @Override
    public void onPartCountChanged(Part part, int count) {
        return;
    }
}
