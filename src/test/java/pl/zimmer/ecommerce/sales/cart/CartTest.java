package pl.zimmer.ecommerce.sales.cart;

import org.junit.jupiter.api.Test;
import pl.zimmer.ecommerce.sales.cart.Cart;
import pl.zimmer.ecommerce.sales.cart.CartItem;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CartTest {

    @Test
    void newCartIsEmpty() {
        Cart cart = Cart.empty();

        assertThat(cart.isEmpty()).isTrue();
    }

    @Test
    void notEmptyWhenProductAdded(){
        Cart cart = Cart.empty();
        String productId = thereIsProduct("x");

        cart.addProduct(productId);

        assertThat(cart.isEmpty()).isFalse();
    }

    @Test
    void cartConsiderSameProductAsSingleItemS1() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct("x");

        cart.addProduct(productId);

        assertThat(cart.getItemsCount()).isEqualTo(1);
    }

    @Test
    void cartConsiderSameProductAsSingleItemS2() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct("x");

        cart.addProduct(productId);
        cart.addProduct(productId);

        assertThat(cart.getItemsCount()).isEqualTo(1);
    }
    @Test
    void cartConsiderSameProductAsSingleItemS3() {
        Cart cart = Cart.empty();
        String productX = thereIsProduct("x");
        String productY = thereIsProduct("y");


        cart.addProduct(productX);
        cart.addProduct(productY);

        assertThat(cart.getItemsCount()).isEqualTo(2);
    }

    @Test
    void exposeProductQuantityWithCartLineS1() {
        Cart cart = Cart.empty();
        String productX = thereIsProduct("x");

        cart.addProduct(productX);

        List<CartItem> cartItems = cart.getItems();

        assertCartLinesContainsProductWithNQuantity(cartItems, productX, 1);
    }
    @Test
    void exposeProductQuantityWithCartLineS2() {
        Cart cart = Cart.empty();
        String productX = thereIsProduct("x");


        cart.addProduct(productX);
        cart.addProduct(productX);

        List<CartItem> cartItems = cart.getItems();

        assertCartLinesContainsProductWithNQuantity(cartItems, productX, 2);
    }
    @Test
    void exposeProductQuantityWithCartLineS3() {
        Cart cart = Cart.empty();
        String productX = thereIsProduct("x");
        String productY = thereIsProduct("y");


        cart.addProduct(productX);
        cart.addProduct(productX);
        cart.addProduct(productY);
        cart.addProduct(productY);
        cart.addProduct(productY);


        List<CartItem> cartItems = cart.getItems();

        assertCartLinesContainsProductWithNQuantity(cartItems, productX, 2);
        assertCartLinesContainsProductWithNQuantity(cartItems, productY, 3);
    }

    private void assertCartLinesContainsProductWithNQuantity(List<CartItem> cartItems, String productId, int expectedQuantity) {
        assertThat(cartItems)
                .filteredOn(cartItem -> cartItem.getProductId().equals(productId))
                .extracting(cartItem -> cartItem.getQuantity())
                .first()
                .isEqualTo(expectedQuantity);
    }

    private String thereIsProduct(String id) {
        return id;
    }

}
