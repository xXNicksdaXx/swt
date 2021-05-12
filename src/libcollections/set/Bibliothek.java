package libcollections.set;

import java.util.*;

public class Bibliothek {
    private Set<Buch> bestand;

    public Bibliothek() {
        bestand = new TreeSet<Buch>();
    }

    public boolean sortiertesEinfuegen(Buch neuesBuch) {
        // Set wie Menge, also nicht sortierbar
        // TreeSet wie Baum, deswegen "Struktur" vorhanden, mehr auch nicht
        return bestand.add(neuesBuch);
    }

    public Buch sucheNachISBN(String isbn) {
        //funktioniert nur mit foreach-Schleife, weil kein Index für for-Schleife
        for (Buch buch: bestand) {
            if (buch.getIsbn().equals(isbn)) {
                return buch;
            }
        }
        return null;
    }

    public Collection<Buch> sucheNachAutor(String autor) {
        // Wiederholung: Wie können wir nach Autor suchen?
        Set<Buch> buecher = new TreeSet<Buch>();
        for (Buch buch: bestand) {
            if (buch.getAutor().equals(autor)) {
                buecher.add(buch);
            }
        }
        return buecher;
    }

    public Map<String, Set<Buch> > bestandNachAutorAuflisten() {
        Map<String, Set<Buch>> ausgabe = new HashMap<>();
        for (Buch buch : bestand) {
            String autor = buch.getAutor();
            if (ausgabe.containsKey(autor)) {
                // Autor schon bekannt
                Set<Buch> bekannteBuecher = ausgabe.get(autor);
                bekannteBuecher.add(buch);
                ausgabe.put(autor, bekannteBuecher);
            } else {
                // Autor nicht bekannt
                Set<Buch> bekannteBuecher = new TreeSet<Buch>();
                bekannteBuecher.add(buch);
                ausgabe.put(autor, bekannteBuecher);
            }
        }
        return ausgabe;
    }

    // Hinweis: Collection ist generisches Interface
    // Interface = Vertrag über Attribute und Methoden
    // (Listen, Sets und Maps impl. das Interface)
    public Collection<Buch> getBestand() {
        return bestand;
    }
}