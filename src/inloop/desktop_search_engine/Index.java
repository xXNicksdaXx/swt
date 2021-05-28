package inloop.desktop_search_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {
    private Map<String, List<Resource>> index;

    public Index(){
        index = new HashMap<>();
    }

    public void add (Resource res){
        if(res == null) throw new NullPointerException("res cannot be null!");
        List<Resource> update;
        if (index.containsKey(res.getName())){
            update = index.get(res.getName());
        }
        else {
            update = new ArrayList<>();
        }
        update.add(res);
        index.replace(res.getName(), update);
    }

    public List<Resource> getResources(String keyword){
        if(keyword == null) throw new NullPointerException("keyword cannot be null!");
        if(keyword.equals("")) throw new IllegalArgumentException("keyword cannot be empty!");
        return index.get(keyword);
    }

}
