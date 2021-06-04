package designpattern.bibliothek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Bibliothek {

    //PATTERN: FACTORY METHOD
    //Bibliothek hier die "Factory"

    //das Interface List ist in dem Fall das "Product"
    private List<Buch> bestand;
    private static final int ARRAYLIST = 1;
    private static final int LINKEDLIST = 2;

    Bibliothek(int variante) {
        switch (variante) {
            //"Concrete Product 1"
            case ARRAYLIST:
                bestand = new ArrayList<Buch>();
                break;
            //"Concrete Product 2"
            case LINKEDLIST:
                bestand = new LinkedList<Buch>();
                break;
            default:
                throw new IllegalArgumentException("unbekanntes Argument: " + variante);
        }
    }

    void neuesBuchAufnehmen(Buch neuesBuch, Aufnehmen algorithmus) {
        algorithmus.neuesBuch(bestand, neuesBuch);
    }
}