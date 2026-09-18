public interface PaymentComponent {
    boolean processPayment(String recipient, double amount);
    String getPaymentMethod();
}
