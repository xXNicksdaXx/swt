package inloop.desktop_search_engine;

/*
Could be used for real files out of resource?
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
*/
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

    public String getAsString (Resource res) /*throws IOException*/ {
        /*String stringPath = res.getPath();
        Path realPath = Paths.get(stringPath);
        return Files.readString(realPath); */
        return "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    }
}
