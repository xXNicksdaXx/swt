package inloop.desktop_search_engine;

import java.util.*;

public class Index {
    private Map<String, List<Resource>> index;

    public Index(){
        index = new HashMap<>();
    }

    public void add (Resource res){
        if(res == null) throw new NullPointerException("res cannot be null!");
        Set<String> keywords = res.getType().getCollector().getKeywords(res);
        List<Resource> update;
        for (String keyword : keywords){
            if (index.containsKey(keyword)){
                update = index.get(keyword);
            }
            else {
                update = new ArrayList<>();
            }
            update.add(res);
            index.replace(keyword, update);
        }
    }

    public List<Resource> getResources(String keyword){
        if(keyword == null) throw new NullPointerException("keyword cannot be null!");
        return index.get(keyword);
    }
}
