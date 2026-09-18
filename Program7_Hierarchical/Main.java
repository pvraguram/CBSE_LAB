public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 7: Hierarchical Composition (CBSE Lab)");
        System.out.println("=================================================");
        System.out.println("  Structure: ShoppingCart [parent] -> PaymentService [child]\n");
        PaymentService upi = new UPIPaymentService("shopper@okicici");
        CartService cart = new ShoppingCart(upi);
        System.out.println("Adding items to cart:");
        cart.addItem("Bluetooth Speaker", 1299.00);
        cart.addItem("Phone Case", 299.00);
        cart.addItem("USB-C Cable", 199.00);
        cart.checkout("merchant@store");
    }
}
