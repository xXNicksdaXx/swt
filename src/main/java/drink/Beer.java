package drink;

public class Beer extends Drink {
    private String brewery;

    public void Beer (String brewery) {
        this.brewery = brewery;
    }

    public String getBrewery() {
        return brewery;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "[" + brewery + "]";
    }
}