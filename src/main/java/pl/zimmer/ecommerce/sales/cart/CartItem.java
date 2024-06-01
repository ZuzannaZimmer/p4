package pl.zimmer.ecommerce.sales.cart;

public class CartItem {
    private final String productId;
    private final Integer qty;

    public CartItem(String productId, Integer qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Object getProductId() {
        return productId;
    }

    public Object getQuantity() {
        return qty;
    }
}
