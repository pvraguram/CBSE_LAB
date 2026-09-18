public class UPIPaymentService implements PaymentService {
    private final String upiId;
    public UPIPaymentService(String upiId) {
        this.upiId = upiId;
    }
    @Override
    public boolean pay(double amount, String to) {
        System.out.printf("    [Child - UPI Payment] Rs.%.2f sent from '%s' to '%s'%n", amount, upiId, to);
        return true;
    }
    @Override
    public String getMethodName() {
        return "UPI (" + upiId + ")";
    }
}
