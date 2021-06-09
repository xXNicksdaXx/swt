package libcollections.map;

import java.util.*;

public class Bibliothek {
    private Map<String, Set<Buch>> bestand;

    public Bibliothek() {
        bestand = new TreeMap<String, Set<Buch>>();
    }

    public boolean sortiertesEinfuegen(Buch neuesBuch) {
        if (!bestand.containsKey(neuesBuch.getAutor())) {
            bestand.put(neuesBuch.getAutor(), new TreeSet<Buch>());
        }
        Set<Buch> buecherDesAutors = bestand.get(neuesBuch.getAutor());
        return buecherDesAutors.add(neuesBuch);
    }

    public Buch sucheNachISBN(String isbn) {
        // Wiederholung: Wie können Bücher gefunden werden?
        for (Set<Buch> value : bestand.values()) {
            for (Buch buch : value) {
                if (buch.getIsbn().equals(isbn)) {
                    return buch;
                }
            }
        }
        return null;
    }

    public Collection<Buch> sucheNachAutor(String autor) {
        // Wiederholung: Wie können wir nach Autor suchen?
        Set<Buch> buecherDesAutors = bestand.get(autor);
        if (buecherDesAutors == null) {
            return new TreeSet<Buch>();
        }
        return buecherDesAutors;
    }

    public Map<String, Set<Buch>> bestandNachAutorAuflisten() {
        return bestand;
    }

    // Hinweis: Collection ist generisches Interface
    // Interface = Vertrag über Attribute und Methoden
    // (Listen, Sets und Maps impl. das Interface)
    public Collection<Buch> getBestand() {
        Set<Buch> ergebnis = new TreeSet<Buch>();
        for (Set<Buch> buecher : bestand.values()) {
            ergebnis.addAll(buecher);
        }
        return ergebnis;
    }
}