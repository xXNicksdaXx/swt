package inloop.predicateIterator;

public class HasLength implements Predicate<String> {
    private int length;

    public HasLength(int length){
        if (length < 0) throw new IllegalArgumentException("length should never be negative!");
        this.length =length;
    }
    public boolean test(String value){
        if (value == null) return false;
        return value.length() == length;
    }
}
