package stueckliste;

import java.util.*;

//Pattern 2: Composite ~ Composite
public class Baugruppe extends Bauteil {
    Set<Bauteil> bauteile;

    public Baugruppe(Bauteil teil, String id) {
        this.id = id;
        bauteile = new HashSet<>();
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
        if (bauteile.size() <= 1) throw new IllegalArgumentException("Die Baugruppe mit der ID "+this.getId()+"muss mindestens ein Teil enthalten.");
        bauteile.remove(teil);
    }
}
