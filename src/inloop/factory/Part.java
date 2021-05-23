package inloop.factory;

public abstract class Part {
    private String id;
    private String name;

    public Part(String id, String name){
        if(id == null) throw new NullPointerException("id cannot be null!");
        if(id.equals("")) throw new IllegalArgumentException("id cannot be empty!");
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

