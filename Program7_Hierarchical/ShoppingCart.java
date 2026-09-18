import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart implements CartService {
    private final Map<String, Double> items = new LinkedHashMap<>();
    private final PaymentService paymentService;

    public ShoppingCart(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @Override
    public void addItem(String itemName, double price) {
        items.put(itemName, price);
        System.out.printf("  [Cart] Added %-30s Rs.%.2f%n", itemName, price);
    }
    @Override
    public double getTotalAmount() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
    @Override
    public void checkout(String paymentTarget) {
        System.out.println("\n  ---- Cart Summary ----");
        items.forEach((item, price) -> System.out.printf("    %-30s Rs.%.2f%n", item, price));
        System.out.printf("    %-30s Rs.%.2f%n", "TOTAL", getTotalAmount());
        System.out.println("\n  Payment via: " + paymentService.getMethodName());
        boolean ok = paymentService.pay(getTotalAmount(), paymentTarget);
        System.out.println("\n  Checkout: " + (ok ? "SUCCESSFUL" : "FAILED"));
    }
}
