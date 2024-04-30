package pl.regula.ecommerce.catalog;

import java.util.List;

public interface ProductStorage {
    List<Product> allProducts();

    Product getProductBy(String id);

    void add(Product newProduct);
}
