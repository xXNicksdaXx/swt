package inloop.factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReceivingStock extends Stock{
    private int minStockItems;
    private int maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems){
        if(minStockItems <= 0) throw new IllegalArgumentException("minStock should be positive!");
        if(maxStockItems <= 0 || maxStockItems < minStockItems) throw new IllegalArgumentException("maxStock should be greater than minStock and 0!");
        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;
        Map<Part, Integer> parts = new HashMap<>();
        Set<StockObserver> observers = new HashSet<>();
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
        return super.insert(part, amount);
    }

    @Override
    public boolean remove(Part part, int amount){
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(amount <= 0) throw new IllegalArgumentException("amount should be positive!");
        return super.remove(part, amount);
    }
}
