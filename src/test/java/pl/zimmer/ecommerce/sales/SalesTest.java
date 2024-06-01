package pl.zimmer.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.zimmer.ecommerce.sales.cart.CartStorage;
import pl.zimmer.ecommerce.sales.offering.Offer;
import pl.zimmer.ecommerce.sales.offering.OfferCalculator;
import pl.zimmer.ecommerce.sales.reservation.ReservationRepository;
import pl.zimmer.ecommerce.sales.reservation.SpyPaymentGateway;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SalesTest {

    @Test
    void itShowsCurrentOffer() {
        //ARRANGE
        SalesFacade sales = thereIsSales();
        String customerId = thereIsCustomer("Zuza");

        //ACT
        Offer offer = sales.getCurrentOffer(customerId);

        //ASSERT
        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(0));
        assertThat(offer.getItemsCount()).isEqualTo(0);
    }

    private SalesFacade thereIsSales() {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new SpyPaymentGateway(),
                new ReservationRepository());
    }


    private String thereIsCustomer(String name) {

        return name;
    }

    @Test
    void itAddsProductToCart() {
        SalesFacade sales = thereIsSales();
        String customerId = thereIsCustomer("Zuza");
        String productId = thereIsProduct("x",BigDecimal.valueOf(10));

        sales.addProductToCart(customerId,productId);

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(offer.getItemsCount()).isEqualTo(1);


    }

    private String thereIsProduct(String id, BigDecimal price) {

        return id;
    }

    @Test
    void itAllowsToRemoveProductFromCart() {

    }

    @Test
    void itAllowsToAcceptOffer() {

    }


}
