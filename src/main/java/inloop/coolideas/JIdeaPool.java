package inloop.coolideas;

import java.util.*;

public class JIdeaPool {
    private Map<JTopic, Set<JIdea>> pool;

    public JIdeaPool(){
        pool = new HashMap<>();
    }

    public void add(JTopic topic){
        if(topic == null) throw new NullPointerException("topic cannot be null!");
        if(!pool.containsKey(topic)) pool.put(topic, new HashSet<>());
    }

    public void add(JIdea idea, JTopic topic){
        if(idea == null) throw new NullPointerException("idea cannot be null!");
        if(topic == null) throw new NullPointerException("topic cannot be null!");

        Collection<Set<JIdea>> allSets = pool.values();
        Set<JIdea> allIdeas = new HashSet<>();
        for(Set<JIdea> set : allSets){
            allIdeas.addAll(set);
        }
        for(JIdea i : allIdeas){
            if(i.getTitle().equals(idea.getTitle()) && (i != idea)) return;
        }

        if(pool.containsKey(topic)){
            Set<JIdea> set = pool.get(topic);
            set.add(idea);
            pool.replace(topic, set);
        }
        else{
            Set<JIdea> set = new HashSet<>();
            set.add(idea);
            pool.put(topic, set);
        }
    }

    public boolean remove(JTopic topic){
        if(topic == null) throw new NullPointerException("topic cannot be null!");

        if(pool.containsKey(topic)){
            pool.remove(topic);
            return true;
        }
        else return false;
    }

    public boolean remove(JIdea idea){
        if(idea == null) throw new NullPointerException("idea cannot be null!");
        boolean found = false;

        Set<JTopic> topics = pool.keySet();
        for(JTopic topic : topics){
            Set<JIdea> set = pool.get(topic);
            if (set.contains(idea)){
                set.remove(idea);
                found = true;
                pool.replace(topic, set);
            }
        }
        return found;
    }

    public JIdea getIdea(String title){
        if(title == null) throw new NullPointerException("title cannot be null!");
        if(title.equals("")) throw new IllegalArgumentException("title cannot be empty!");

        Set<JTopic> topics = pool.keySet();
        for(JTopic topic : topics){
            Set<JIdea> set = pool.get(topic);
            for (JIdea idea : set){
                if(idea.getTitle().equals(title)) return idea;
            }
        }
        return null;
    }

    public int numberOfTopics(){
        return pool.size();
    }

    public int numberOfIdeas(){
        Collection<Set<JIdea>> allSets = pool.values();
        Set<JIdea> returner = new HashSet<>();
        for(Set<JIdea> set : allSets){
            returner.addAll(set);
        }
        return returner.size();
    }

    public void removeDeclined(){
        Set<JTopic> topics = pool.keySet();
        for(JTopic topic : topics){
            Set<JIdea> set = pool.get(topic);
            set.removeIf(JIdea::isDeclined);
            pool.replace(topic, set);
        }
    }

    public void removeReleased(){
        Set<JTopic> topics = pool.keySet();
        for(JTopic topic : topics){
            Set<JIdea> set = pool.get(topic);
            set.removeIf(JIdea::isReleased);
            pool.replace(topic, set);
        }
    }
}
