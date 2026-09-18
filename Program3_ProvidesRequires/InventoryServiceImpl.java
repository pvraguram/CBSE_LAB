import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImpl implements InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryServiceImpl() {
        stock.put("P001", 10);
        stock.put("P002", 0);
        stock.put("P003", 5);
    }
    @Override
    public boolean isAvailable(String productId, int quantity) {
        int available = stock.getOrDefault(productId, 0);
        System.out.println("  [InventoryService] Stock for " + productId + ": " + available + " unit(s).");
        return available >= quantity;
    }
    @Override
    public void reserveStock(String productId, int quantity) {
        int current = stock.getOrDefault(productId, 0);
        stock.put(productId, current - quantity);
        System.out.println("  [InventoryService] Reserved " + quantity + " unit(s) of " + productId + ". Remaining stock: " + stock.get(productId));
    }
}
