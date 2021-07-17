package inloop.coolideas;

public abstract class JContent {
    private String title;
    private String description;

    public JContent(String title, String description){
        if(title == null) throw new NullPointerException("title cannot be null!");
        if(title.equals("")) throw new IllegalArgumentException("title cannot be empty!");
        if(description == null) throw new NullPointerException("description cannot be null!");
        if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");

        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String toString();
}
