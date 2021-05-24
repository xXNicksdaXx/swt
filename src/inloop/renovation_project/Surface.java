package inloop.renovation_project;

import java.util.Map;

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

    public void setSelectedMaterial (Material material){
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
        return 0;
    }

    @Override
    public Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials) {
        if (selectedMaterial == null) throw new NullPointerException("there must be a selected material to every surface!");
        if(!materials.containsKey(selectedMaterial.getName())){
            materials.put(selectedMaterial.getName(), selectedMaterial.getMaterialRequirements(this));
        }
        else {
            String key = selectedMaterial.getName();
            materials.replace(key, materials.get(key) + selectedMaterial.getMaterialRequirements(this));
        }
        return materials;
    }
}
