package pruefung.real;

import java.util.*;

public abstract class Node {
    protected String name;

    public Node(String name) {
        if (name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
    }

    public abstract int size();

    public abstract List<File> textSearch(String text);

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + name + ")";
    }
}