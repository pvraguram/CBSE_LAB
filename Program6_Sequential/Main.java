public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 6: Sequential Composition (CBSE Lab)");
        System.out.println(" Pipeline: Order -> Payment -> Receipt");
        System.out.println("=================================================\n");
        OrderContext context = new OrderContext("ORD-2024-101", "Wireless Mouse", 799.00);
        SequentialComposer pipeline = new SequentialComposer();
        pipeline.addStep(new OrderProcessor());
        pipeline.addStep(new PaymentStep("UPI"));
        pipeline.addStep(new ReceiptGenerator());
        pipeline.execute(context);
        System.out.println("\nFinal Receipt Number : " + context.getReceiptNumber());
        System.out.println("Payment Status       : " + (context.isPaymentSuccess() ? "SUCCESS" : "FAILED"));
    }
}
