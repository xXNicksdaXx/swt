package inloop.factory;

public class Factory {
    private Purchasing purchasing;
    private ReceivingStock receivingStock;

    public Factory(Purchasing purchasing, ReceivingStock receivingStock){
        if(purchasing == null) throw new NullPointerException("purchasing cannot be null!");
        if(receivingStock == null) throw new NullPointerException("receivingStock cannot be null!");
        this.purchasing = purchasing;
        this.receivingStock = receivingStock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public ReceivingStock getReceivingStock() {
        return receivingStock;
    }

    public static Part createPart(PartType partType, String id, String name){
        if(partType == null) throw new NullPointerException("partType cannot be null!");
        if(id == null) throw new NullPointerException("id cannot be null!");
        if(id.equals("")) throw new IllegalArgumentException("id cannot be empty!");
        if(name == null) throw new NullPointerException("name cannot be null!");
        if(name.equals("")) throw new IllegalArgumentException("name cannot be empty!");

        if(partType == PartType.COMPONENTS) return new Components(id, name);
        if (partType == PartType.SINGLE_COMPONENT) return new SingleComponent(id, name);
        else return new Resource(id, name);
    }
}
