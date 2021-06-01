package designpattern.bibliothek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Bibliothek {
    private List<Buch> bestand;
    private static final int ARRAYLIST = 1;
    private static final int LINKEDLIST = 2;

    Bibliothek(int variante) {
        switch (variante) {
        case ARRAYLIST:
            bestand = new ArrayList<Buch>();
            break;
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