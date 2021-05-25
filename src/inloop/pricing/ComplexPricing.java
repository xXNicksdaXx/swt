package inloop.pricing;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplexPricing implements ISalePricing {
    private List<ISalePricing> pricings;

    public ComplexPricing(ISalePricing pricing){
        if(pricing == null) throw new NullPointerException("pricing cannot be null!");
        pricings = new ArrayList<>();
        pricings.add(pricing);
    }

    public void add(ISalePricing pricing) {
        if(pricing == null) throw new NullPointerException("pricing cannot be null!");
        pricings.add(pricing);
    }

    public List<ISalePricing> getPricings() {
        return pricings;
    }
}
