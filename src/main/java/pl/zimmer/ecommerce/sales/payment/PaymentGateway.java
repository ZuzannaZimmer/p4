package pl.zimmer.ecommerce.sales.payment;

public interface PaymentGateway {
    PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest);
}
