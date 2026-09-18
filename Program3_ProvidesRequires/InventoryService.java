public interface InventoryService {
    boolean isAvailable(String productId, int quantity);
    void reserveStock(String productId, int quantity);
}
