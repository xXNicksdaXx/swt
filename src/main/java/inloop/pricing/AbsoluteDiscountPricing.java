package inloop.pricing;

public class AbsoluteDiscountPricing implements ISalePricing{
    private long discount;
    private long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold){
        if(discount <= 0) throw new IllegalArgumentException("discount must be greater than 0!");
        if(threshold <= 0) throw new IllegalArgumentException("threshold must be greater than 0!");
        if(threshold <= discount) throw new IllegalArgumentException("threshold must be greater than discount!");
        this.discount = discount;
        this.threshold = threshold;
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale == null) throw new NullPointerException("sale cannot be null!");
        long prePrice = sale.getPreDiscountTotal();
        if (prePrice <= threshold) return prePrice;
        long price = prePrice - discount;
        if(price <= threshold) return threshold;
        return price;
    }
}
