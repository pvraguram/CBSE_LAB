public interface PricingService {
    double applyDiscount(double originalPrice, double discountPercent);
    double calculateTotal(double unitPrice, int quantity);
}
