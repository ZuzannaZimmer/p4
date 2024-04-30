package pl.regula.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.*;

public class ProductCatalog {

    private ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {

        this.productStorage = productStorage;

    }


    public String addProduct(String name, String description){
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);

        productStorage.add(newProduct);
        return id.toString();
    }

    public void changePrice(String id, BigDecimal bigDecimal) {
        Product product = getProductBy(id);
        product.changePrice(bigDecimal);


    }

    public Product getProductBy(String id) {
        return productStorage.getProductBy(id);
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }
}
