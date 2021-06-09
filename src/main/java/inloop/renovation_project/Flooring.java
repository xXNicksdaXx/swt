package inloop.renovation_project;

public class Flooring extends Material{
    private static double limit = 0.02;
    private double widthOfFlooring;

    public Flooring(String name, double price, double width) {
        super(name, price);
        if(width <= 0) throw new IllegalArgumentException("width should be positive!");
        this.widthOfFlooring = width;
    }

    public double getWidth() {
        return widthOfFlooring;
    }

    @Override
    public int getMaterialRequirements(Surface surface) {
        if(surface == null) throw new NullPointerException("surface cannot be null!");
        return (int)(surface.getArea() / getWidth() - limit + 1);
    }
}
