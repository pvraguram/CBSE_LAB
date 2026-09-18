public class PaymentComponent implements Component {
    @Override
    public String getComponentName() {
        return "PaymentComponent";
    }
    @Override
    public String getComponentVersion() {
        return "2.1";
    }
    @Override
    public String getComponentDescription() {
        return "Handles payment processing via Credit Card or UPI.";
    }
    public void process(String method, double amount) {
        System.out.println("  [PaymentComponent] Processing Rs." + amount + " via " + method);
    }
}
