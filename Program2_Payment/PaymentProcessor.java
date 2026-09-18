public class PaymentProcessor {
    private PaymentComponent paymentComponent;
    public PaymentProcessor(PaymentComponent paymentComponent) {
        this.paymentComponent = paymentComponent;
    }
    public void setPaymentComponent(PaymentComponent paymentComponent) {
        this.paymentComponent = paymentComponent;
    }
    public void checkout(String merchant, double amount) {
        System.out.println("  Payment method : " + paymentComponent.getPaymentMethod());
        boolean success = paymentComponent.processPayment(merchant, amount);
        System.out.println("  Checkout       : " + (success ? "SUCCESS" : "FAILED"));
    }
}
