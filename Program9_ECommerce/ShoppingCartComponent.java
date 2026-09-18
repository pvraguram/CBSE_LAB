import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCartComponent implements AppComponent {
    private final Map<String, Integer> cartItems = new LinkedHashMap<>();
    private final ProductCatalog catalog;
    private final PricingService pricing;
    private PaymentGateway paymentGateway;

    public ShoppingCartComponent(ProductCatalog catalog, PricingService pricing, PaymentGateway paymentGateway) {
        this.catalog = catalog;
        this.pricing = pricing;
        this.paymentGateway = paymentGateway;
    }
    public void setPaymentGateway(PaymentGateway gateway) {
        this.paymentGateway = gateway;
    }
    public boolean addToCart(String productId, int quantity) {
        if (!catalog.exists(productId)) {
            System.out.println("    [Cart] Product not found: " + productId);
            return false;
        }
        cartItems.merge(productId, quantity, Integer::sum);
        System.out.printf("    [Cart] Added %-20s x%d  @  Rs.%.2f each%n", catalog.getProductName(productId), quantity, catalog.getUnitPrice(productId));
        return true;
    }
    public void checkout(double discountPercent, String merchant) {
        System.out.println("\n  ---- Cart Contents ----");
        double subtotal = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String pid = entry.getKey();
            int qty = entry.getValue();
            double line = pricing.calculateTotal(catalog.getUnitPrice(pid), qty);
            subtotal += line;
            System.out.printf("    %-22s x%d  =  Rs.%.2f%n", catalog.getProductName(pid), qty, line);
        }
        double finalAmount = pricing.applyDiscount(subtotal, discountPercent);
        System.out.printf("%n    Subtotal            : Rs.%.2f%n", subtotal);
        System.out.printf("    Discount (%s%%)       : - Rs.%.2f%n", (int) discountPercent, subtotal - finalAmount);
        System.out.printf("    Amount Payable      : Rs.%.2f%n", finalAmount);
        System.out.println("\n  ---- Payment ----");
        System.out.println("    Method: " + paymentGateway.getMethodName());
        boolean paid = paymentGateway.pay(finalAmount, merchant);
        System.out.println("\n  ---- Receipt ----");
        if (paid) {
            String receipt = "RCPT-" + System.currentTimeMillis();
            System.out.println("    Receipt No   : " + receipt);
            System.out.printf("    Total Paid   : Rs.%.2f%n", finalAmount);
            System.out.println("    Status       : CHECKOUT SUCCESSFUL");
        } else {
            System.out.println("    Status       : CHECKOUT FAILED");
        }
    }
    @Override
    public String getComponentName()    { return "ShoppingCartComponent"; }
    @Override
    public String getComponentVersion() { return "1.0"; }
}
