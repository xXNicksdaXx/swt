package stueckliste;

import libcollections.set.Buch;

import java.util.*;

//Pattern 2: Composite ~ Composite
public class Baugruppe extends Bauteil {
    protected Set<Bauteil> bauteile;

    public Baugruppe(Bauteil teil, String id) {
        this.id = id;
        bauteile = new HashSet<Bauteil>();
        bauteile.add(teil);
    }

    @Override
    public double preis() {
        double preis = 0;
        for (Bauteil teil : bauteile){
            preis += teil.preis();
        }
        return preis;
    }

    public void addBauteil(Bauteil teil){
        int i = bauteile.size();
        bauteile.add(teil);
        if(i == bauteile.size()) System.out.println("Das Bauteil mit der ID "+teil.getId()+" ist bereits Teil der Baugruppe.");
    }

    public void removeBauteil(Bauteil teil){
        if(!bauteile.contains(teil)) throw new IllegalArgumentException("Das Teil mit der ID "+teil.getId()+" ist nicht Teil der Baugruppe.");
        bauteile.remove(teil);
    }
}
