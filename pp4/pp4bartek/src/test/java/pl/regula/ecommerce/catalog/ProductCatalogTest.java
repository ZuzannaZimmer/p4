package pl.regula.ecommerce.catalog;

import org.assertj.core.api.BigDecimalAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProductCatalogTest {
    @Test
    void itListsProducts(){
        ProductCatalog catalog = getProductCatalog();

        List<Product> productList = catalog.allProducts();

        assert productList.isEmpty();
//        assertThat(productList).hasSize(0);

    }
    @Test
    void itAllowsToaddProducts(){
        ProductCatalog catalog = getProductCatalog();

        List<Product> productList = catalog.allProducts();
        assertThat(productList).hasSize(0);
    }
    @Test
    void itLoadsProductDetalis(){
        ProductCatalog catalog = getProductCatalog();
        String id = catalog.addProduct("Lego set 8083","Nice");

       Product loaded = catalog.getProductBy(id);

        assertThat(id).isEqualTo(loaded.getId());
    }

    private static ProductCatalog getProductCatalog() {
        ProductCatalog catalog = new ProductCatalog(new ArrayListProductStorage());
        return catalog;
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = getProductCatalog();
        String id = catalog.addProduct("Lego set 8083","Nice");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loadedProduct = catalog.getProductBy(id);
        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loadedProduct.getPrice());
    }

}
