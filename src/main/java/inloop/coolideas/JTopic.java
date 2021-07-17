package inloop.coolideas;

public class JTopic extends JContent{
    private final int id;

    public JTopic(String title, String description, int id) {
        super(title, description);
        if(id <= 0) throw new IllegalArgumentException("id cannot be negative or 0!");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Topic: "+getTitle()+"\n"+getDescription();
    }
}
