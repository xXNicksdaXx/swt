package inloop.event_app;

import java.util.*;

public class EventCatalogImpl extends TreeMap<Event, Set<Time>> implements EventCatalog {
    private static final TreeMap<Event, Set<Time>> instance = new EventCatalogImpl();

    private EventCatalogImpl() {}

    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (tSet == null) throw new NullPointerException("tSet cannot be null");

        if(!instance.containsKey(e)){
            Set<Time> input = new HashSet<>();
            for(Time t : tSet){
                //if(t.getHour() < 0 || t.getHour() > 23) continue;
                //if(t.getMinute() < 0 || t.getMinute() > 59) continue;
                input.add(t);
            }
            instance.put(e, input);
            return true;
        }
        else return false;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (t == null) throw new NullPointerException("t cannot be null");

        if(!instance.containsKey(e)) return false;
        Set<Time> input = instance.get(e);
        if(input.contains(t)) return false;
        else {
            input.add(t);
            return true;
        }
    }

    @Override
    public Set<Event> getAllEvents() {
        return instance.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (!instance.containsKey(e)) throw new NoSuchElementException("e is not part of instance!");

        return instance.get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if(category == null) throw new NullPointerException("category cannot be null!");

        Map<Event, Set<Time>> filter = new TreeMap<>();
        Set<Event> eventSet = getAllEvents();
        for (Event e : eventSet){
            if(!(e.getCategory() == category)) continue;
            filter.put(e,instance.get(e));
        }
        return filter;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if(instance.containsKey(e)){
            Set<Time> tSet = getTimesOfEvent(e);
            instance.remove(e);
            return tSet;
        }
        return null;
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if (e == null) throw new NullPointerException("e cannot be null!");
        if (t == null) throw new NullPointerException("t cannot be null!");
        if(instance.containsKey(e)){
            Set<Time> tSet = getTimesOfEvent(e);
            if(!tSet.contains(t)) return false;
            tSet.remove(t);
            instance.replace(e, tSet);
            return true;
        }
        return false;
    }
}
