package pl.zimmer.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.zimmer.ecommerce.catalog.ArrayListProductStorage;
import pl.zimmer.ecommerce.catalog.ProductCatalog;
import pl.zimmer.ecommerce.infrastructure.PayUPaymentGw;
import pl.zimmer.ecommerce.sales.cart.CartStorage;
import pl.zimmer.ecommerce.sales.offering.OfferCalculator;
import pl.zimmer.ecommerce.sales.SalesFacade;
import pl.zimmer.ecommerce.sales.reservation.ReservationRepository;

@SpringBootApplication
public class App {
    public static void main (String[] args) {
        System.out.println("Here we go");
        SpringApplication.run(App.class,args);
    }

    @Bean
    SalesFacade createSalesFacade() {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                new PayUPaymentGw(),
                new ReservationRepository()
                );
    }

    @Bean
    ProductCatalog createMyCatalog() {
        var catalog = new ProductCatalog(new ArrayListProductStorage());
        catalog.addProduct("Lego set 8083","nice one ");
        catalog.addProduct("Cobi bricks","nice one ");

        return catalog;
    }
}
