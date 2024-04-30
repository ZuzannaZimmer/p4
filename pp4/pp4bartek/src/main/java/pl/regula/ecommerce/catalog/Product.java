package pl.regula.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String description;

    private BigDecimal price;
    public Product(UUID id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
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
