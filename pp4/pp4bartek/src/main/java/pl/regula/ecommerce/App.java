package pl.regula.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.regula.ecommerce.catalog.ArrayListProductStorage;
import pl.regula.ecommerce.catalog.ProductCatalog;
import pl.regula.ecommerce.sales.SalesFacade;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Here we go!!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    SalesFacade createSalesFacade(){
        return new SalesFacade();
    }

    @Bean
    ProductCatalog createMyCatalog(){
        var catalog = new ProductCatalog(new ArrayListProductStorage());
        catalog.addProduct("Lego set 8083","Nice one");
        catalog.addProduct("Cobi bricks","Nice one");

        return catalog;
    }
}
