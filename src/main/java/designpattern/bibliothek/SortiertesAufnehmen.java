package designpattern.bibliothek;

import java.util.Collections;
import java.util.List;

class SortiertesAufnehmen implements Aufnehmen {
    //"Concrete Strategy 2"

    @Override
    public void neuesBuch(List<Buch> liste, Buch buch) {
        liste.add(buch);
        Collections.sort(liste);
    }
}
