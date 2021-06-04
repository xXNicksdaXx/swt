package inloop.auction_system;

import java.util.LinkedList;
import java.util.List;

public abstract class Auction {
    private List<Item> allItems;
    private List<Person> bidders;
    private boolean closed;

    public Auction(){
        allItems = new LinkedList<>();
        bidders = new LinkedList<>();
        closed = false;
    }

    public void addBid(Item bidItem, String nameOfBidder, long price){

    }

    public String closeAuction(){
        closed = true;
        return "";
    }

    public String generateAllBidsString(Item item){
        return "";
    }

    public String generateItemListString(){
        return "";
    }

    public void registerItem(Item item){

    }

    public abstract String generateItemString(Item item);

    public List<Item> getAllItems(){
        return allItems;
    }
}
