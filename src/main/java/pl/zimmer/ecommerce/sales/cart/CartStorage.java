package pl.zimmer.ecommerce.sales.cart;

import pl.zimmer.ecommerce.sales.cart.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CartStorage {
    Map<String, Cart> carts;

    public CartStorage(){
        this.carts = new HashMap<>();
    }

    public Optional<Cart> loadForCustomer(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    public void save(String customerId, Cart cart) {
        carts.put(customerId, cart);
    }
}

