package pl.zimmer.ecommerce.sales;

import pl.zimmer.ecommerce.sales.cart.Cart;
import pl.zimmer.ecommerce.sales.cart.CartStorage;
import pl.zimmer.ecommerce.sales.payment.PaymentDetails;
import pl.zimmer.ecommerce.sales.payment.PaymentGateway;
import pl.zimmer.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.zimmer.ecommerce.sales.reservation.AcceptOfferRequest;
import pl.zimmer.ecommerce.sales.offering.Offer;
import pl.zimmer.ecommerce.sales.offering.OfferCalculator;
import pl.zimmer.ecommerce.sales.reservation.Reservation;
import pl.zimmer.ecommerce.sales.reservation.ReservationDetails;
import pl.zimmer.ecommerce.sales.reservation.ReservationRepository;

import java.util.UUID;

public class SalesFacade {

    private CartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(CartStorage cartStorage, OfferCalculator offerCalculator,PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRepository;
    }


    public Offer getCurrentOffer(String customerId) {
        Cart cart = cartStorage.loadForCustomer(customerId).orElse(Cart.empty());

        Offer offer = offerCalculator.calculate(cart.getItems());

        return offer;
    }

    public void addProductToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);

        cartStorage.save(customerId, cart);
    }
private Cart loadCartForCustomer(String customerId){
        return cartStorage.loadForCustomer(customerId)
                .orElse(Cart.empty());
}

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId = UUID.randomUUID().toString();
        Offer offer = this.getCurrentOffer(customerId);

        PaymentDetails paymentDetails = paymentGateway.registerPayment(
                RegisterPaymentRequest.of(reservationId, acceptOfferRequest, offer.getTotal())
        );

        Reservation reservation = Reservation.of(
                reservationId,
                customerId,
                acceptOfferRequest,
                offer,
                paymentDetails);

        reservationRepository.add(reservation);

        return new ReservationDetails(reservationId, paymentDetails.getPaymentUrl());
    }
}
