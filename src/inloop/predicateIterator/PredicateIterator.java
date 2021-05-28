package inloop.predicateIterator;

import java.util.*;

public class PredicateIterator<T> implements Iterator<T>{
    private Iterator<T> iter;
    private Predicate<T> predicate;
    private T nextT;
    private boolean nextAvailable = false;

    public PredicateIterator(Iterator<T> iter, Predicate<T> predicate){
        if (iter == null) throw new NullPointerException("iter should never be null!");
        if (predicate == null) throw new NullPointerException("predicate should never be null!");
        this.iter = iter;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        if (nextAvailable || setNextT()) return true;
        else return false;
    }

    @Override
    public T next() {
        if (!nextAvailable && !setNextT()) {
            throw new NoSuchElementException();
        }
        nextAvailable = false;
        return nextT;
    }

    private boolean setNextT() {
        while (iter.hasNext()) {
            T object = iter.next();
            if (predicate.test(object)) {
                nextT = object;
                nextAvailable = true;
                return true;
            }
        }
        return false;
    }
}
