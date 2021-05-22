package inloop.factory;

import java.util.Map;

public class Stock {
    private Map<Part, Integer> parts;

    public int getCount(Part part){
        return 1;
    }

    public boolean insert(Part part, int amount){
        return true;
    }

    public boolean remove(Part part, int amount){
        return true;
    }

    public void addObserver(StockObserver observer){

    }

    private void notifyPartCountChanged(Part part){

    }
}
