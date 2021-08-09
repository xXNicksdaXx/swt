package pruefung.real;

import java.util.*;

public class Directory extends Node {
    private List<Node> children;

    public Directory(String name) {
        super(name);
        this.children = new LinkedList<>();
    }

    public boolean addNode(Node node) {
        if(node == null) return false;
        return children.add(node);
    }

    public boolean removeNode(Node node) {
        if(node == null) return false;
        return children.remove(node);
    }

    @Override
    public int size() {
        int size = 0;
        for(Node node : children){
            size += node.size();
        }
        return size;
    }

    @Override
    public List<File> textSearch(String text) {
        if (text.equals("")) throw new IllegalArgumentException("text cannot be empty!");
        List<File> list = new LinkedList<>();
        for(Node node : children){
            List<File> current = node.textSearch(text);
            list.addAll(current);
        }
        return list;
    }
}