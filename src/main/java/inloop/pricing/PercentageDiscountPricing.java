package inloop.pricing;

public class PercentageDiscountPricing implements ISalePricing {
    private double percentage;

    public PercentageDiscountPricing (double percentage){
        if(percentage <= 0) throw new IllegalArgumentException("percentage must be greater than 0%!");
        if(percentage >= 100) throw new IllegalArgumentException("percentage must be smaller than 100%!");
        this.percentage = percentage;
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale == null) throw new NullPointerException("sale cannot be null!");
        long price = (long)(sale.getPreDiscountTotal() / 100 * (100-percentage));
        return price;
    }
}
