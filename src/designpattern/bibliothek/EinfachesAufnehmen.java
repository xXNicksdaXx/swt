package designpattern.bibliothek;

import java.util.List;

class EinfachesAufnehmen implements Aufnehmen {
    //"Concrete Strategy 1"

    @Override
    public void neuesBuch(List<Buch> liste, Buch buch) {
        liste.add(buch);
    }
}
