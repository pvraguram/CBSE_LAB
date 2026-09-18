public class PaymentStep implements OrderStep {
    private final String paymentMethod;
    public PaymentStep(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    @Override
    public void execute(OrderContext context) {
        System.out.println("|- [Stage 2] PAYMENT COMPONENT");
        System.out.println("|  Method   : " + paymentMethod);
        System.out.println("|  Amount   : Rs." + context.getAmount());
        boolean success = true;
        context.setPaymentSuccess(success);
        System.out.println("|  Status   : " + (success ? "Payment APPROVED" : "Payment DECLINED"));
        System.out.println("|- Passing to receipt stage.\n");
    }
}
