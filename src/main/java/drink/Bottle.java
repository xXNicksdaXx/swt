package drink;

public class Bottle<genericDrink extends Drink> {
    private genericDrink content = null;

    public boolean isEmpty(){
        return content == null;
    }

    public void fill (genericDrink drink) {
        if (drink == null) {
            throw new IllegalArgumentException();
        }
        if (content != null) {
            throw new IllegalStateException();
        }
        this.content = drink;
    }

    public genericDrink empty(){
        if (content == null) {
            throw new IllegalStateException();
        }
        genericDrink drink = content;
        content = null;
        return drink;
    }
}
