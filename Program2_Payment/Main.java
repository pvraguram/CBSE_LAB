public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 2: Payment Component (CBSE Lab)");
        System.out.println("=================================================");
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment("4111-XXXX-XXXX-1234"));
        System.out.println("\n--- Checkout using Credit Card ---");
        processor.checkout("Amazon Store", 1500.00);
        System.out.println("\n>>> Replacing CreditCardPayment with UPIPayment...\n");
        processor.setPaymentComponent(new UPIPayment("shopper@oksbi"));
        System.out.println("--- Checkout using UPI (same client call) ---");
        processor.checkout("Amazon Store", 1500.00);
    }
}
