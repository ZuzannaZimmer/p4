package pl.zimmer.ecommerce.infrastructure;

import pl.zimmer.ecommerce.sales.payment.PaymentDatails;
import pl.zimmer.ecommerce.sales.payment.PaymentGateway;
import pl.zimmer.ecommerce.sales.payment.RegisterPaymentRequest;

public class PayUPaymentGw implements PaymentGateway {
    @Override
    public PaymentDatails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }
}
