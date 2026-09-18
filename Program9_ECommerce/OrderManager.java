public class OrderManager implements AppComponent {
    private final ProductCatalog catalog;
    private final StockService stock;
    public OrderManager(ProductCatalog catalog, StockService stock) {
        this.catalog = catalog;
        this.stock = stock;
    }
    public boolean confirmOrder(String productId, int quantity) {
        System.out.println("  [OrderManager] Confirming order: " + productId + " x" + quantity);
        if (!catalog.exists(productId)) {
            System.out.println("  [OrderManager] REJECTED - product not in catalogue.");
            return false;
        }
        if (!stock.inStock(productId, quantity)) {
            System.out.println("  [OrderManager] REJECTED - insufficient stock.");
            return false;
        }
        stock.reserve(productId, quantity);
        System.out.println("  [OrderManager] CONFIRMED - " + catalog.getProductName(productId) + " x" + quantity + " @ Rs." + catalog.getUnitPrice(productId) + " each.");
        return true;
    }
    @Override
    public String getComponentName()    { return "OrderManager"; }
    @Override
    public String getComponentVersion() { return "1.1"; }
}
