package inloop.renovation_project;

import java.util.*;

public class StructuredObject extends RenovationObject {
    private Set<RenovationObject> parts;

    public StructuredObject(){
        parts = new HashSet<>();
    }

    public void add(RenovationObject renovationObject){
        if (renovationObject == null) throw new NullPointerException("renovationObject should never be null!");
        parts.add(renovationObject);
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (RenovationObject ro : parts){
            price += ro.getPrice();
        }
        return price;
    }

    @Override
    public Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials) {
        if (materials == null) throw new NullPointerException("materials should never be null!");
        Map<String, Integer> update = new HashMap<>(materials);
        String test1 = null; Integer test2 = null;
        if (update.containsKey(test1)) throw new NullPointerException("materials-key should never be null!");
        if (update.containsValue(test2)) throw new NullPointerException("materials-value should never be null!");
        for (RenovationObject p : parts){
            update = p.addMaterialRequirements(update);
        }
        return update;
    }
}
