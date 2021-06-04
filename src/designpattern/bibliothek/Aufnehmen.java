package designpattern.bibliothek;

import java.util.List;

interface Aufnehmen {
    //PATTERN: STRATEGY

    //Klasse Aufnehmen als "Strategy",
    // wobei die Klasse Bibliothek der "Context ist"
    void neuesBuch(List<Buch> liste, Buch buch);
}
