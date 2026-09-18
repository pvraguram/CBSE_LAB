public interface ProductCatalog {
    String getProductName(String productId);
    double getUnitPrice(String productId);
    boolean exists(String productId);
}
