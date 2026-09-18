public class CreditCardPayment implements PaymentComponent {
    private final String maskedCardNumber;
    public CreditCardPayment(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }
    @Override
    public boolean processPayment(String recipient, double amount) {
        System.out.println("  [Credit Card] Charging Rs." + amount + " from card " + maskedCardNumber + " to '" + recipient + "'");
        return true;
    }
    @Override
    public String getPaymentMethod() {
        return "Credit Card (" + maskedCardNumber + ")";
    }
}
