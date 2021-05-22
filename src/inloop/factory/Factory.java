package inloop.factory;

public class Factory {
    private Purchasing purchasing;
    private ReceivingStock receivingStock;

    public Factory(Purchasing purchasing, ReceivingStock receivingStock){
        this.purchasing = purchasing;
        this.receivingStock = receivingStock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public ReceivingStock getReceivingStock() {
        return receivingStock;
    }

    public Part createPart(PartType partType, String id, String name){
        return null;
    }
}
