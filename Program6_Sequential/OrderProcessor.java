public class OrderProcessor implements OrderStep {
    @Override
    public void execute(OrderContext context) {
        System.out.println("|- [Stage 1] ORDER COMPONENT");
        System.out.println("|  Order ID : " + context.getOrderId());
        System.out.println("|  Product  : " + context.getProduct());
        System.out.println("|  Amount   : Rs." + context.getAmount());
        System.out.println("|- Order confirmed. Passing to payment stage.\n");
    }
}
