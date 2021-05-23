package inloop.part_project;

public class Purchasing implements StockObserver{
    private ReceivingStock receivingStock;

    public Purchasing(ReceivingStock receivingStock){
        if(receivingStock == null) throw new NullPointerException("receivingStock cannot be null!");
        this.receivingStock = receivingStock;
    }

    public void buy(Part part, int count){
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(count <= 0) throw new IllegalArgumentException("amount should be positive!");
        receivingStock.insert(part,count);
    }

    public ReceivingStock getStock() {
        return receivingStock;
    }

    @Override
    public void onPartCountChanged(Part part, int count) {
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(count <= 0) throw new IllegalArgumentException("amount should be positive!");

        if (receivingStock.getMinStockItems() > count) {
            buy(part, receivingStock.getMaxStockItems()-count);
        }
        if (receivingStock.getMaxStockItems() < count) {
            receivingStock.remove(part, count- receivingStock.getMaxStockItems());
            throw new IllegalArgumentException("current amount is bigger than maximum");
        }
    }
}
