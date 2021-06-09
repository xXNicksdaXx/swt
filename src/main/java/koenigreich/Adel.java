package koenigreich;

public class Adel extends Einwohner {
    public int steuer() {
        int tax = super.steuer();
        if(tax < 20) tax = 20;
        return tax;
    }
}
