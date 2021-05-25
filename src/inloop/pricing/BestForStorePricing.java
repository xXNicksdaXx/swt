package inloop.pricing;

import java.util.List;

public class BestForStorePricing extends ComplexPricing{

    public BestForStorePricing(ISalePricing pricing) {
        super(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale == null) throw new NullPointerException("sale cannot be null!");
        List<ISalePricing> methods = getPricings();
        long current = methods.get(0).getTotal(sale);
        methods.remove(0);
        for(ISalePricing price : methods){
            long newPrice = price.getTotal(sale);
            if (newPrice > current) current = newPrice;
        }
        return current;
    }
}
