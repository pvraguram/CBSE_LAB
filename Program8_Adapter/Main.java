public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 8: Adapter Component (CBSE Lab)");
        System.out.println("=================================================");
        System.out.println("\n--- Case 1: Modern PaymentComponent ---");
        PaymentComponent modern = (amount, recipient) -> {
            System.out.println("  [Modern Gateway] Paying Rs." + amount + " to '" + recipient + "' ... OK");
            return true;
        };
        PaymentClient client1 = new PaymentClient(modern);
        client1.buy("Laptop Stand", 999.00, "TechMart");
        System.out.println("\n--- Case 2: Legacy Gateway via Adapter ---");
        LegacyPaymentGateway legacy = new LegacyPaymentGateway();
        PaymentComponent adapter = new LegacyPaymentAdapter(legacy);
        PaymentClient client2 = new PaymentClient(adapter);
        client2.buy("Mechanical Keyboard", 3500.00, "Gadget Store");
    }
}
