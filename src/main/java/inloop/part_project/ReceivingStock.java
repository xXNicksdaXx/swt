package inloop.part_project;

public class ReceivingStock extends Stock{
    private int minStockItems;
    private int maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems){
        if(minStockItems <= 0) throw new IllegalArgumentException("minStock should be positive!");
        if(maxStockItems <= 0 || maxStockItems <= minStockItems) throw new IllegalArgumentException("maxStock should be greater than minStock and 0!");
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
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(amount <= 0) throw new IllegalArgumentException("amount should be positive!");
        super.insert(part, amount);
        if (getCount(part) > maxStockItems){
            super.remove(part, amount);
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Part part, int amount){
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(amount <= 0) throw new IllegalArgumentException("amount should be positive!");
        return super.remove(part, amount);
    }
}
