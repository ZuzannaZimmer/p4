package pl.zimmer.ecommerce.sales.reservation;

import java.math.BigDecimal;

public class CustomerDetails {
    private final String customerId;
    private final String firstname;
    private final String lastname;
    private final String email;

    public CustomerDetails(String customerId, String firstname, String lastname, String email) {

        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public String getEmail() {
        return null;
    }
}
