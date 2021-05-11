package drink;

public class Demo {
    public static void main(String[] args) {
        // Flasche erstellen, befüllen …
        Bottle<WhiteWine> bottle = new Bottle<WhiteWine>();  // auch möglich: Diamant-Operator <> seit Java 7
        bottle.fill(new WhiteWine("Pfalz"));

        // Folgendes wäre nicht kompilierbar:
        // bottle.fill(new Beer("Leffe"));

        // Ebenfalls nicht kompilierbar (weil keine Kovarianz wie bei Arrays):
        // Bottle<Drink> anotherBottle = new Bottle<WhiteWine>();

        // Außerdem sind Arrays mit generischen Klassen illegal:
        // Bottle<Beer>[] beerBox = new Bottle<Beer>[20];

        // … und entleeren
        WhiteWine wine = bottle.empty();

        // getRegion() aufrufen
        System.out.println("Wein aus der Region " + wine.getRegion());

        // oder die überschriebene toString()-Methode
        System.out.println("toString(): " + wine);

        // nochmaliges Entleeren führt zur Exception
        bottle.empty();
    }
}
