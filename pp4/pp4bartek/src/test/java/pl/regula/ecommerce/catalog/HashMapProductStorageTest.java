package pl.regula.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.*;
public class HashMapProductStorageTest {
    private static final String EXAMPLE_PRODUCT_NAME = "example";

    @Test
    void isStoresAndLoadProduct(){
        ProductStorage storage = thereIsProductStorage();
        Product product = thereIsExampleProduct();

        storage.add(product);
        List<Product> allProducts = storage.allProducts();

        assertThat(allProducts)
                .hasSize(1)
                .extracting(p -> p.getName())
                .contains(EXAMPLE_PRODUCT_NAME);
    }

    private Product thereIsExampleProduct(){
        var p = new Product(UUID.randomUUID(), EXAMPLE_PRODUCT_NAME, "some des");
                return p;
    }
    private ProductStorage thereIsProductStorage (){
        return new ArrayListProductStorage();
    }
}
