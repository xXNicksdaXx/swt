package inloop.auction_system;

public class EnglishAuction extends Auction{
    @Override
    public String generateItemString(Item item) {
        if(item == null) throw new NullPointerException("item cannot be null!");
        String returnString = item.toString() + "\n";
        if (item.getHighestBid() == null)
            returnString += "No bids placed";
        else
            returnString += "Highest bid: " + item.getHighestBid().toString();
        return returnString;
    }
}
