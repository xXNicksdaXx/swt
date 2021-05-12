package libcollections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Bibliothek {
    private List<Buch> bestand;

    public Bibliothek() {
        bestand = new LinkedList<Buch>();
        // oder
        // bestand = new ArrayList<Buch>();
    }

    public boolean sortiertesEinfuegen(Buch neuesBuch) {
        bestand.add(neuesBuch);  // Rückgabewert von List.add(…) ist immer true
        Collections.sort(bestand);
        return true;
    }

    public Buch sucheNachISBN(String isbn) {
        // binäre Suche in einer sortierten Liste
        int index = Collections.binarySearch(bestand, new Buch(isbn));
        if (index < 0) {
            return null;
        }
        return bestand.get(index);
    }

    public Collection<Buch> sucheNachAutor(String autor) {
        // sequentielle Suche im Buchbestand
        Collection<Buch> suchergebnis = new ArrayList<Buch>();
        for (int i = 0; i < bestand.size(); i++) {
            if (autor.equals((bestand.get(i)).getAutor())) {
                suchergebnis.add(bestand.get(i));
            }
        }
        return suchergebnis;
    }
}
