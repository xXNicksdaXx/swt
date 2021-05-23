package inloop.renovation_project;

import java.util.Map;

public class Surface extends RenovationObject{
    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface(double length, double width){
        this.length = length;
        this.width = width;
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
    public Map<String, Integer> addMaterialRequirements() {
        return null;
    }
}
