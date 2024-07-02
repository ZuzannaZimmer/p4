package pl.zimmer.ecommerce.payu;

public class PayUCredentials {

    private String clientSecret;
    private String clientId;
    private boolean sandbox;

    public PayUCredentials (String clientId, String clientSecret, boolean sandbox){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.sandbox = sandbox;
    }
    public static PayUCredentials sandbox(String clientId, String clientSecret){
        return new PayUCredentials(clientId, clientSecret, true);
    }

    public String getBaseURL(){

        if(sandbox){
            return "http://secure.snd.payu.com";
        } else {
            return "http://secure.payu.com";
        }
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
//    "grant_type=client_credentials&client_id=%s&client_secret=%s",
//            "300746",
//            "2ee86a66e5d97e3fadc400c9f19b065d"
}
