package inloop.desktop_search_engine;

import java.util.Iterator;

public class TextFileIterator implements Iterator<String> {
    public TextFileIterator(Resource res){
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove is not supported!");
    }

    public String getAsString (Resource res){
        return "";
    }
}
