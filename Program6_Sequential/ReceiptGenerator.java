public class ReceiptGenerator implements OrderStep {
    @Override
    public void execute(OrderContext context) {
        System.out.println("|- [Stage 3] RECEIPT COMPONENT");
        if (!context.isPaymentSuccess()) {
            System.out.println("|  Status : Cannot generate receipt - payment was not successful.");
            System.out.println("|- Pipeline ended with errors.\n");
            return;
        }
        String receiptNo = "REC-" + System.currentTimeMillis();
        context.setReceiptNumber(receiptNo);
        System.out.println("|  Receipt No : " + receiptNo);
        System.out.println("|  Order ID   : " + context.getOrderId());
        System.out.println("|  Product    : " + context.getProduct());
        System.out.println("|  Amount     : Rs." + context.getAmount());
        System.out.println("|- Receipt generated successfully.\n");
    }
}
