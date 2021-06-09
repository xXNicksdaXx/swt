package inloop.desktop_search_engine;

public class ResourceType {
    private final String description;
    private final KeywordCollector collector;

    public ResourceType(String desc, KeywordCollector collector){
        if(desc == null) throw new NullPointerException("desc cannot be null!");
        if(desc.equals("")) throw new IllegalArgumentException("desc cannot be empty!");
        if(collector == null) throw new NullPointerException("collector cannot be null!");
        this.description = desc;
        this.collector = collector;
    }

    public String getDescription() {
        return description;
    }

    public KeywordCollector getCollector() {
        return collector;
    }
}
