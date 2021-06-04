package inloop.auction_system;

public class Bid {
    private final long price; //read only?
    private final Person bidder;

    public Bid(Person bidder, long price){
        if(bidder == null) throw new NullPointerException("bidder cannot be null!");
        if(price <= 0) throw new IllegalArgumentException("price should be above 0!");

        this.bidder = bidder;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "";
    }
}
