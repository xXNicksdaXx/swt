package koenigreich;

public class Leibeigener extends Bauer {
    public int zuVersteuerndesEinkommen() {
        int zve = super.zuVersteuerndesEinkommen() - 12;
        if (zve < 0) zve = 0;
        return zve;
    }
}
