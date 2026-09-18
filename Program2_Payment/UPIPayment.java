public class UPIPayment implements PaymentComponent {
    private final String upiId;
    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }
    @Override
    public boolean processPayment(String recipient, double amount) {
        System.out.println("  [UPI] Transferring Rs." + amount + " from '" + upiId + "' to '" + recipient + "'");
        return true;
    }
    @Override
    public String getPaymentMethod() {
        return "UPI (" + upiId + ")";
    }
}
