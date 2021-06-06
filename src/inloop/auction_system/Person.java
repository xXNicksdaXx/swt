package inloop.auction_system;

public class Person {
    private String name;

    public Person(String name){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}