package inloop.factory;

import java.util.Map;
import java.util.Set;

public abstract class Stock {
    private Map<Part, Integer> parts;
    private Set<StockObserver> observers;

    public int getCount(Part part){
        if(part == null) throw new NullPointerException("part cannot be null!");
        return parts.get(part);
    }

    public boolean insert(Part part, int amount){
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(amount <= 0) throw new IllegalArgumentException("amount should be positive!");

        if (!parts.containsKey(part)){
            parts.put(part, amount);
        }
        else{
            parts.replace(part, parts.get(part) + amount);
        }
        notifyPartCountChanged(part);
        return true;
    }

    public boolean remove(Part part, int amount){
        if(part == null) throw new NullPointerException("part cannot be null!");
        if(amount <= 0) throw new IllegalArgumentException("amount should be positive!");

        if (!parts.containsKey(part)) return false;
        if (parts.get(part) < amount) return false;
        else {
            parts.replace(part, parts.get(part) - amount);
            notifyPartCountChanged(part);
            return true;
        }
    }

    public void addObserver(StockObserver observer){
        if(observer == null) throw new NullPointerException("observer cannot be null!");
        observers.add(observer);
    }

    private void notifyPartCountChanged(Part part){
        System.out.println("The amount of "+part.getName()+" ("+part.getId()+") changed: "+parts.get(part));
        for(StockObserver o : observers) o.onPartCountChanged(part, parts.get(part));
    }
}
