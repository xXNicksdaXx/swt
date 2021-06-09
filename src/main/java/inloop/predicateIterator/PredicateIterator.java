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
        while (iter.hasNext()) {
            T object = iter.next();
            if (predicate.test(object)) {
                nextT = object;
                nextAvailable = true;
                return true;
            }
        }
        nextAvailable = false;
        return false;
    }

    @Override
    public T next() {
        if (!nextAvailable && !hasNext()) {
            throw new NoSuchElementException();
        }
        nextAvailable = false;
        return nextT;
    }
}
