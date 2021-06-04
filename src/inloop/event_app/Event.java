package inloop.event_app;

public class Event implements Comparable<Event>{
    private String title;
    private EventCategory category;

    public Event(String title, EventCategory category){
        if (title == null) throw new NullPointerException("title cannot be null!");
        if (title.equals("")) throw new IllegalArgumentException("title cannot be empty!");
        if (category == null) throw new NullPointerException("category cannot be null!");
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public EventCategory getCategory() {
        return category;
    }

    @Override
    public int compareTo(Event o) {
        if (o == null) throw new NullPointerException("category cannot be null!");
        if(this.getTitle().compareTo(o.getTitle()) == 0) return this.getCategory().compareTo(o.getCategory());
        else return this.getTitle().compareTo(o.getTitle());
    }
}