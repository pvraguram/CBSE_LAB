public class PaymentClient {
    private final PaymentComponent payment;
    public PaymentClient(PaymentComponent payment) {
        this.payment = payment;
    }
    public void buy(String itemName, double price, String merchant) {
        System.out.println("  Purchasing: '" + itemName + "'  Rs." + price + "  from: " + merchant);
        boolean ok = payment.makePayment(price, merchant);
        System.out.println("  Result    : " + (ok ? "Purchase SUCCESS" : "Purchase FAILED"));
    }
}
