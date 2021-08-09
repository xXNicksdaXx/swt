package pruefung.real;

import java.util.*;

public class File extends Node {
    private String contents;

    public File(String name, String contents) {
        super(name);
        if (contents.equals("")) throw new IllegalArgumentException("contents cannot be empty!");
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public int size() {
        return contents.length();
    }

    @Override
    public List<File> textSearch(String text) {
        if (text.equals("")) throw new IllegalArgumentException("text cannot be empty!");
        if(!contents.contains(text)) return new LinkedList<>();
        else {
            List<File> file = new LinkedList<>();
            file.add(this);
            return file;
        }
    }
}