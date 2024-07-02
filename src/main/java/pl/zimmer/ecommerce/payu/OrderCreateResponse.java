package pl.zimmer.ecommerce.payu;

public class OrderCreateResponse {

    String redirectUri;
    String orderId;
    String extOrderId;
    Status status;

    public OrderCreateResponse setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OrderCreateResponse setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderCreateResponse setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }
    public OrderCreateResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getExtOrderId() {
        return extOrderId;
    }
    public Status getStatus() {return status;}
}
