package stueckliste;

public class Demo {
    public static void main(String[] args) {
        Einzelteil t1 = new Einzelteil("E001", 2.30);
        Einzelteil t2 = new Einzelteil("E002", 4.70);
        Baugruppe t3 = new Baugruppe(t1, "B001");
        Baugruppe t4 = new Baugruppe(t2, "B002");
        t3.addBauteil(t4);
        t3.addBauteil(t2);
        t3.addBauteil(t4);
        t3.removeBauteil(t4);
    }
}
