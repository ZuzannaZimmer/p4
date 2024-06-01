package pl.zimmer.ecommerce.sales.payment;

public interface PaymentGateway {
    PaymentDatails registerPayment(RegisterPaymentRequest registerPaymentRequest);
}
