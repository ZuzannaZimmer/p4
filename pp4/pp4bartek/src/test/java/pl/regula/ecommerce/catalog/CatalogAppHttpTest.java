package pl.regula.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class CatalogAppHttpTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate http;

    @Autowired
    ProductCatalog catalog;

    @Test
    void itLoadsEcommerceHomepage(){
        var url = String.format("http://localhost:%s/api/products", port);
        catalog.addProduct("My Example Product", "ex desc");

        ResponseEntity<Product[]> response = http.getForEntity(url, Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .hasSizeGreaterThan(1)
                .extracting("name")
                .contains("My Example Product");
    }

}

