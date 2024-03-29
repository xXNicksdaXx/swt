/*
 * Beispiel für Java-Datenstrukturen "Bestellung" zur Vorlesung
 * "Softwaretechnologie".
 * (c) 2013-2021  Heinrich Hussmann und Uwe Aßmann, TU Dresden
 */
package bestellung;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<E> extends AbstractCollection<E> implements Collection<E> {
    private class Elem {
        private E elem;
        private Elem next;

        public Elem(E elem, Elem next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Elem start = null;
    private Elem end = null;
    private int size = 0;

    @Override
    public boolean add(E o) {
        Elem e = new Elem(o, null);
        if (end != null) {
            end.next = e;
        }
        if (start == null) {
            start = e;
        }
        end = e;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private class MyCollectionIterator implements Iterator {
        private Elem current;

        public MyCollectionIterator() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E o = current.elem;
            current = current.next;
            return o;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator iterator() {
        return new MyCollectionIterator();
    }
}
