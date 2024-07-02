package pl.zimmer.ecommerce.sales.reservation;

import pl.zimmer.ecommerce.sales.payment.PaymentDetails;
import pl.zimmer.ecommerce.sales.payment.PaymentGateway;
import pl.zimmer.ecommerce.sales.payment.RegisterPaymentRequest;

public class SpyPaymentGateway implements PaymentGateway {
    Integer requestConut = 0;
    public RegisterPaymentRequest lastRequest;

    public Integer getRequestCount() {
        return requestConut;
    }

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        this.requestConut++;
        lastRequest = registerPaymentRequest;
        return new PaymentDetails("http://spy-gateway/%s");
    }
}
