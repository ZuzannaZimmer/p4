package pl.zimmer.ecommerce.sales.reservation;

import pl.zimmer.ecommerce.sales.payment.PaymentDatails;
import pl.zimmer.ecommerce.sales.payment.PaymentGateway;
import pl.zimmer.ecommerce.sales.payment.RegisterPaymentRequest;

public class SpyPaymentGateway implements PaymentGateway {
    Integer requestConut = 0;
    public RegisterPaymentRequest lastRequest;

    public Integer getRequestCount() {
        return requestConut;
    }

    @Override
    public PaymentDatails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        this.requestConut++;
        lastRequest = registerPaymentRequest;
        return new PaymentDatails("http://spy-gateway/%s");
    }
}
