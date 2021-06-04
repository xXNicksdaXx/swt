package inloop.auction_system;

import java.util.List;

public class Item {
    private String name;
    private String description;
    private long minPrice;
    private Bid highestBid;
    private List<Bid> allBids;

    public Item(String name, String description, long minPrice){
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");
        if(description == null) throw new NullPointerException("description cannot be null!");
        if(description.equals("")) throw new IllegalArgumentException("description cannot be empty!");
        if(minPrice <= 0) throw new IllegalArgumentException("minPrice should be above 0!");

        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
    }

    public void addBid(Person bidder, long price){

    }

    public List<Bid> getAllBids() {
        return allBids;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    @Override
    public String toString(){
        return "";
    }
}
