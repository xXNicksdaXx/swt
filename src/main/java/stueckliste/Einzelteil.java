package stueckliste;

//Pattern 2: Composite ~ Leaf
public class Einzelteil extends Bauteil {
    private double preis;

    public Einzelteil(String id, double preis) {
        this.preis = preis;
        this.id = id;
    }

    @Override
    public double preis() {
        return preis;
    }
}