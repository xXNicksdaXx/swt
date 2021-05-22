package inloop.factory;

public class Part {
    private String id;
    private String name;

    public Part(String id, String name){
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

