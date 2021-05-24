package inloop.renovation_project;

public class Paint extends Material{
    private static double limit = 0.02;
    private int numberOfCoats;
    private double squareMetersPerLiter;

    public Paint(String name, double price, int numberOfCoats, double squareMetersPerLiter) {
        super(name, price);
        if(numberOfCoats <= 0) throw new IllegalArgumentException("numberOfCoats should be positive!");
        if(squareMetersPerLiter <= 0) throw new IllegalArgumentException("squareMetersPerLiter should be positive!");
        this.numberOfCoats = numberOfCoats;
        this.squareMetersPerLiter = squareMetersPerLiter;
    }

    public int getNumberOfCoats() {
        return numberOfCoats;
    }

    public double getSquareMetersPerLiter() {
        return squareMetersPerLiter;
    }

    @Override
    public int getMaterialRequirements(Surface surface) {
        double paintLiters = surface.getArea() * getNumberOfCoats() / getSquareMetersPerLiter() - limit;
        int bucket = (int)(2 * paintLiters + 1);
        return bucket;
    }
}
