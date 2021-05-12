package koenigreich;

public class Einwohner {
    protected int einkommen; //protected -> Kindklassen haben Zugang

    public void setEinkommen(int einkommen) {
        if (einkommen < 0) {
            throw new IllegalArgumentException("Einkommen darf nicht negativ sein");
        }
        this.einkommen = einkommen;
    }

    public int zuVersteuerndesEinkommen() {
        return einkommen;
    }

    public int steuer() {
        int tax = zuVersteuerndesEinkommen() / 10; //automatisches Abrunden, weil int;
        if(tax < 1) tax = 1;
        return tax;
    }
}