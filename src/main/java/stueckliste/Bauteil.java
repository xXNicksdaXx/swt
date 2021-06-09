package stueckliste;

//Pattern 2: Composite ~ Component
public abstract class Bauteil {
    protected String id;

    public abstract double preis();

    public Bauteil getBauteil(){
        return this;
    }

    public String getId() {
        return id;
    }
}
