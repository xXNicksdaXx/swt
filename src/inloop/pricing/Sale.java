package inloop.pricing;

public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing;

    public Sale(long preDiscountTotal, ISalePricing pricing){
        if(preDiscountTotal <= 0) throw new IllegalArgumentException("normal price must be greater than 0!");
        if(pricing == null) throw new NullPointerException("pricing cannot be null!");
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public long getPreDiscountTotal() {
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing) {
        if(pricing == null) throw new NullPointerException("pricing cannot be null!");
        this.pricing = pricing;
    }

    public long getTotal(){
        return pricing.getTotal(this);
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        if(discountType == null) throw new NullPointerException("discountType cannot be null!");
        if(percentage < 0) throw new IllegalArgumentException("percentage must be at least 0%!");
        if(percentage >= 100) throw new IllegalArgumentException("percentage must be smaller than 100%!");
        if(discount < 0) throw new IllegalArgumentException("discount must be at least 0!");
        if(threshold < 0) throw new IllegalArgumentException("threshold must be at least 0!");
        if(threshold < discount) throw new IllegalArgumentException("threshold must be at least equal to discount!");

        if(discountType == DiscountType.ABSOLUTEDISCOUNT){
            return new AbsoluteDiscountPricing(discount, threshold);
        }
        if(discountType == DiscountType.PERCENTAGEDISCOUNT){
            return new PercentageDiscountPricing(percentage);
        }
        else throw new IllegalStateException("this discountType is not allowed!");
    }
}
