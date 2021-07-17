package inloop.coolideas;

import java.util.HashSet;
import java.util.Set;

public abstract class JContent {
    private String title;
    private String description;
    private Set<ContentObserver> observers;

    public JContent(String title, String description){
        if(title == null) throw new NullPointerException("title cannot be null!");
        if(title.equals("")) throw new IllegalArgumentException("title cannot be empty!");
        if(description == null) throw new NullPointerException("description cannot be null!");
        if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");

        this.title = title;
        this.description = description;
        observers = new HashSet<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null) throw new NullPointerException("description cannot be null!");
        if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");
        this.description = description;
        for(ContentObserver observer : observers){
            observer.update(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null) throw new NullPointerException("title cannot be null!");
        if(title.equals("")) throw new IllegalArgumentException("title cannot be empty!");
        this.title = title;
        for(ContentObserver observer : observers){
            observer.update(this);
        }
    }

    public void addObserver(ContentObserver observer){
        if (observer == null) throw new NullPointerException("observer cannot be null!");
        observers.add(observer);
    }

    public void removeObserver(ContentObserver observer){
        if (observer == null) throw new NullPointerException("observer cannot be null!");
        observers.remove(observer);
    }

    public int countObservers(){
        return observers.size();
    }

    public abstract String toString();
}
