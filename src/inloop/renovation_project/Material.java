package inloop.renovation_project;

public abstract class Material {
    private String name;
    private double price;

    public Material(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return price;
    }

    public abstract int getMaterialRequirements(Surface surface);

    public double getPriceOfASurface(Surface surface) {
        return price;
    }
}
