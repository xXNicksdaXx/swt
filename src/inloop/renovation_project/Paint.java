package inloop.renovation_project;

public class Paint extends Material{
    private static double limit = 0.02;
    private int numberOfCoats;
    private double squareMetersPerLiter;

    public Paint(String name, double price, int numberOfCoats, double squareMetersPerLiter) {
        super(name, price);
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
        return 0;
    }
}
