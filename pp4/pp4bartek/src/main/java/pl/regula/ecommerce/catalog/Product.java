package pl.regula.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private  UUID id;
    private String name;
    private String description;

    private BigDecimal price;
    public Product(UUID id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    Product() {

    }

    public BigDecimal getPrice() {
        return price;
    }

    public Object getId() {
        return id;
    }

    public void changePrice(BigDecimal newPrice) {
        this.price = newPrice;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
