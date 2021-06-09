package inloop.desktop_search_engine;

public class Resource {
    private final String name;
    private final String path;
    private final ResourceType rt;

    public Resource(String name, String path, ResourceType rt){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        if(path == null) throw new NullPointerException("path cannot be null!");
        if(path.equals("")) throw new IllegalArgumentException("path cannot be empty!");
        if(rt == null) throw new NullPointerException("rt cannot be null!");
        this.name = name;
        this.path = path;
        this.rt = rt;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ResourceType getType() {
        return rt;
    }
}
