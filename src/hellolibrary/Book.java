package hellolibrary;

public class Book {

    private String title;
    private boolean isLent;

    //Konstruktor
    public Book(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public boolean getIsLent() {
        return isLent;
    }

    public void setIsLent(boolean lending){
        this.isLent = lending;
    }
}
