package pl.regula.ecommerce.sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SalesTest {
    @Test
    void itAllowsToRemoveProductFromCart(){

    }
    @Test
    void itShowsCurrentOffer(){
        //ARRANGE
        SalesFacade sales = thereIsSalesFacade();
        String customerId =  thereIsCustomer("Kuba");
        //Act
        Offer offer = sales.getCurrentOffer(customerId);
        //Assert
        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(0));
        assertThat(offer.getItemsCount()).isEqualTo(0);
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }

    private String thereIsCustomer(String name) {
        return name;
    }





}
