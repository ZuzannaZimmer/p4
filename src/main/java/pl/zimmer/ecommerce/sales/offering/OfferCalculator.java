package pl.zimmer.ecommerce.sales.offering;

import pl.zimmer.ecommerce.sales.cart.CartItem;
import pl.zimmer.ecommerce.sales.offering.Offer;

import java.math.BigDecimal;
import java.util.List;

public class OfferCalculator {
    public Offer calculate(List<CartItem> lines) {

        return new Offer(BigDecimal.valueOf(10).multiply(new BigDecimal(lines.size())),
                lines.size()
        );
    }
}
