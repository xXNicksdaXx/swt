package inloop.predicateIterator;

import static java.lang.String.valueOf;

public class StartsWith implements Predicate<String> {
    private String prefix;

    public StartsWith(String prefix){
        if (prefix == null) throw new IllegalArgumentException("prefix should never be null!");
        this.prefix = prefix;
    }

    @Override
    public boolean test(String value) {
        if (value == null) return false;
        return value.startsWith(prefix);
    }
}