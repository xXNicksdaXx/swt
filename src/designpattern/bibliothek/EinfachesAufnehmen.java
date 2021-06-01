package designpattern.bibliothek;

import java.util.List;

class EinfachesAufnehmen implements Aufnehmen {
    @Override
    public void neuesBuch(List<Buch> liste, Buch buch) {
        liste.add(buch);
    }
}
