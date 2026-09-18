public interface StockService {
    boolean inStock(String productId, int quantity);
    void reserve(String productId, int quantity);
}
