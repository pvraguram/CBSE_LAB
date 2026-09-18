public class PricingComponent implements PricingService, AppComponent {
    @Override
    public String getComponentName()    { return "PricingComponent"; }
    @Override
    public String getComponentVersion() { return "1.0"; }
    @Override
    public double applyDiscount(double originalPrice, double discountPercent) {
        double discount = (originalPrice * discountPercent) / 100.0;
        return originalPrice - discount;
    }
    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }
}
