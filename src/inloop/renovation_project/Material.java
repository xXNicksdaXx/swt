package inloop.renovation_project;

public abstract class Material {
    private String name;
    private double price;

    public Material(String name, double price){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
        if(price <= 0) throw new IllegalArgumentException("price should be positive!");
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
        if(surface == null) throw new NullPointerException("surface cannot be null!");
        return getPricePerUnit() * getMaterialRequirements(surface);
    }
}
