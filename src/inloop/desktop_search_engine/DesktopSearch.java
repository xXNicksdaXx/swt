package inloop.desktop_search_engine;

import java.util.*;

public class DesktopSearch {
    private Map<String, ResourceType> types;
    private Index index;

    public DesktopSearch(){
        types = new HashMap<>();
    }

    public void registerType(String extension, ResourceType type){
        if(extension == null) throw new NullPointerException("extension cannot be null!");
        if(extension.equals("")) throw new IllegalArgumentException("extension cannot be empty!");
        if(type == null) throw new NullPointerException("type cannot be null!");
        types.put(extension, type);
    }

    public ResourceType getType(String extension) {
        if(extension == null) throw new NullPointerException("extension cannot be null!");
        if(extension.equals("")) throw new IllegalArgumentException("extension cannot be empty!");
        return types.get(extension);
    }

    public void unregisterType(String extension){
        if(extension == null) throw new NullPointerException("extension cannot be null!");
        if(extension.equals("")) throw new IllegalArgumentException("extension cannot be empty!");
        types.remove(extension);
    }

    public void registerResource (Resource res){
        if(res == null) throw new NullPointerException("res cannot be null!");
        index.add(res);
    }

    public List<Resource> processRequest(String request){
        if(request == null) throw new NullPointerException("request cannot be null!");
        if(request.equals("")) throw new IllegalArgumentException("request cannot be empty!");
        return index.getResources(request);
    }
}
