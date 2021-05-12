package libcollections.map;

public class Buch implements Comparable<Buch> {
    private String isbn;
    private String autor;
    private String titel;

    public Buch(String isbn, String autor, String titel) {
        this.isbn = isbn;
        this.autor = autor;
        this.titel = titel;
    }

    public Buch(String isbn) {
        // Konstruktor für Hilfsobjekte zum Vergleichen von Büchern
        // Siehe Übung von letzter Woche -> Collections.binarySearch
        // und Collections.sort
        this(isbn, "", "");
    }

    // Wiederholung: Warum benötigen wir compareTo(Buch buch)?
    @Override // Compiler-Hilfsannotation
    public int compareTo(Buch buch) {
        // Letzte Woche hatten wir dies explizit implementiert
        // Wir können aber die compareTo Funktion
        // auch an String isbn delegieren
        // denn String implementiert Comparable<String>
        return isbn.compareTo(buch.isbn);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    @Override // Compiler-Hilfsannotation
    public String toString() {
        return "ISBN: " + isbn + ", Autor: " + autor + ", Titel: " + titel;
    }

    // Java-Programmierrichtlinie:
    //
    // wenn man compareTo() überschreibt, sollte man equals()
    // und hashCode() analog dazu überschreiben, d.h. ebenfalls
    // isbn als Vergleichskriterium heranziehen

    @Override
    public boolean equals(Object o) {
        if (o instanceof Buch) {
            Buch buch = (Buch) o;
            return isbn.equals(buch.isbn);
        }
        return false;
    }

    // Wiederholung: Woher kommt hashCode, equals und toString?
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}