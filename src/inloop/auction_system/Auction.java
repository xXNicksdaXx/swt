package inloop.auction_system;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

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
        if (closed) throw new IllegalStateException("no bids allowed if closed!");
        if (bidItem == null) throw new NullPointerException("bidItem cannot be null!");
        if (!allItems.contains(bidItem)) throw new NoSuchElementException("bidItem not available!");
        if (nameOfBidder == null) throw new NullPointerException("nameOfBidder cannot be null!");
        if (nameOfBidder.equals("")) throw new IllegalArgumentException("nameOfBidder cannot be empty!");
        if (price <= 0) throw new IllegalArgumentException("price cannot be 0 or below!");

        Person actualBidder = null;
        for (Person p : bidders){
            if(p.getName().equals(nameOfBidder)) {
                actualBidder = p;
                break;
            }
        }
        if(actualBidder == null) actualBidder = new Person(nameOfBidder);

        bidItem.addBid(actualBidder, price);
    }

    public String closeAuction(){
        if (closed) throw new IllegalStateException("auction already closed!");
        closed = true;
        return generateItemListString();
    }

    public String generateAllBidsString(Item item){
        if(item == null) throw new NullPointerException("item cannot be null!");
        String returnString = "All bids:";
        for (Bid bid : item.getAllBids()){
            returnString += "\n" + bid.toString();
        }
        return returnString;
    }

    public String generateItemListString(){
        String returnString = "";
        for(Item item : allItems){
            String itemString = generateItemString(item);
            returnString += itemString + "\n";
        }
        return returnString;
    }

    public void registerItem(Item item){
        if (closed) throw new IllegalStateException("registerItem is not allowed when auction is closed!");
        if (item == null) throw new NullPointerException("item cannot be null!");
        for (Item i : allItems){
            if (i.getName().equals(item.getName())) throw new IllegalArgumentException("two items cannot have the same name");
        }
        allItems.add(item);
    }

    public abstract String generateItemString(Item item);

    public List<Item> getAllItems(){
        return allItems;
    }
}