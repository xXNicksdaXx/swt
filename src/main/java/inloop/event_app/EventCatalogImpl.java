package inloop.event_app;

import java.util.*;

public class EventCatalogImpl extends TreeMap<Event, Set<Time>> implements EventCatalog {
    private static final long serialVersionUID = 1;

    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (tSet == null) throw new NullPointerException("tSet cannot be null");
        for(Time t : tSet){
            if (t == null) throw new NullPointerException("t cannot be null");
        }

        if(!containsKey(e)){
            put(e, tSet);
            return true;
        }
        else return false;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (t == null) throw new NullPointerException("t cannot be null");

        if(!containsKey(e)) return false;
        Set<Time> input = get(e);
        if(input.contains(t)) return false;
        else {
            input.add(t);
            return true;
        }
    }

    @Override
    public Set<Event> getAllEvents() {
        return keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (!containsKey(e)) return null;
        return get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if(category == null) throw new NullPointerException("category cannot be null!");

        Map<Event, Set<Time>> filter = new TreeMap<>();
        Set<Event> eventSet = getAllEvents();
        for (Event e : eventSet){
            if(!(e.getCategory() == category)) continue;
            filter.put(e,get(e));
        }
        return filter;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if(containsKey(e)){
            Set<Time> tSet = getTimesOfEvent(e);
            remove(e);
            return tSet;
        }
        return null;
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (t == null) throw new NullPointerException("t cannot be null!");
        if(containsKey(e)){
            Set<Time> tSet = getTimesOfEvent(e);
            if(!tSet.contains(t)) return false;
            tSet.remove(t);
            replace(e, tSet);
            return true;
        }
        return false;
    }
}
