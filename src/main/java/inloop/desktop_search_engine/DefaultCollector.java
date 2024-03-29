package inloop.desktop_search_engine;

import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector{

    @Override
    public Set<String> getKeywords(Resource res) {
        if(res == null) throw new NullPointerException("res cannot be null!");
        Set<String> keywords = new HashSet<>();
        keywords.add(res.getName());
        return keywords;
    }
}
