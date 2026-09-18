import java.util.HashMap;
import java.util.Map;

public class OrderComponent implements ProductService {
    private final InventoryService inventoryService;
    private final Map<String, String[]> catalogue = new HashMap<>();

    public OrderComponent(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        catalogue.put("P001", new String[]{"Wireless Headphones", "2999.00"});
        catalogue.put("P002", new String[]{"Mechanical Keyboard",  "4500.00"});
        catalogue.put("P003", new String[]{"USB-C Hub",            "1299.00"});
    }
    @Override
    public String getProductDetails(String productId) {
        String[] info = catalogue.get(productId);
        if (info == null) return "Unknown product: " + productId;
        return "Product[" + productId + "] " + info[0];
    }
    @Override
    public double getProductPrice(String productId) {
        String[] info = catalogue.get(productId);
        if (info == null) return 0.0;
        return Double.parseDouble(info[1]);
    }
    public void placeOrder(String productId, int quantity) {
        System.out.println("\n  [OrderComponent] Placing order — " + productId + " x" + quantity);
        System.out.println("  Product  : " + getProductDetails(productId));
        System.out.println("  Price    : Rs." + getProductPrice(productId));
        if (inventoryService.isAvailable(productId, quantity)) {
            inventoryService.reserveStock(productId, quantity);
            double total = getProductPrice(productId) * quantity;
            System.out.println("  Total    : Rs." + total);
            System.out.println("  Status   : ORDER PLACED SUCCESSFULLY.");
        } else {
            System.out.println("  Status   : ORDER FAILED — Out of stock.");
        }
    }
}
