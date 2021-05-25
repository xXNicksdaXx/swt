package inloop.pricing;

import java.util.List;

public class BestForCustomerPricing extends ComplexPricing{

    public BestForCustomerPricing(ISalePricing pricing) {
        super(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale == null) throw new NullPointerException("sale cannot be null!");
        List<ISalePricing> methods = getPricings();
        long current = sale.getPreDiscountTotal();
        for(ISalePricing price : methods){
            long newPrice = price.getTotal(sale);
            if (newPrice < current) current = newPrice;
        }
        return current;
    }
}
