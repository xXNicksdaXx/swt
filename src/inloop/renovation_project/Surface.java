package inloop.renovation_project;

import java.util.*;

public class Surface extends RenovationObject{
    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface(double length, double width){
        if(length <= 0) throw new IllegalArgumentException("length should be positive!");
        if(width <= 0) throw new IllegalArgumentException("width should be positive!");
        this.length = length;
        this.width = width;
    }

    public void setMaterial (Material material){
        if (material == null) throw new NullPointerException("material should never be null!");
        this.selectedMaterial = material;
    }

    public double getArea(){
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPrice() {
        return selectedMaterial.getPriceOfASurface(this);
    }

    @Override
    public Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials) {
        if (materials == null) throw new NullPointerException("materials should never be null!");
        Map<String, Integer> update = new HashMap<>(materials);
        String test1 = null; Integer test2 = null;
        if (update.containsKey(test1)) throw new NullPointerException("materials-key should never be null!");
        if (update.containsValue(test2)) throw new NullPointerException("materials-value should never be null!");

        if (selectedMaterial == null) throw new NullPointerException("there must be a selected material to every surface!");
        String key = selectedMaterial.getName();
        if(!update.containsKey(key)){
            update.put(key, selectedMaterial.getMaterialRequirements(this));
        }
        else {
            update.replace(key, materials.get(key) + selectedMaterial.getMaterialRequirements(this));
        }
        return update;
    }
}
