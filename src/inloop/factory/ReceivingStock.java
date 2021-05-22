package inloop.factory;

public class ReceivingStock extends Stock{
    private int minStockItems;
    private int maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems){
        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;
    }

    public int getMinStockItems() {
        return minStockItems;
    }

    public int getMaxStockItems() {
        return maxStockItems;
    }

    @Override
    public boolean insert(Part part, int amount){
        return true;
    }

    @Override
    public boolean remove(Part part, int amount){
        return true;
    }
}
