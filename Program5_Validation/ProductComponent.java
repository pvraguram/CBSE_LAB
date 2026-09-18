public class ProductComponent implements Validatable {
    private final String productId;
    private final String name;
    private final double price;
    private final int stock;
    public ProductComponent(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name      = name;
        this.price     = price;
        this.stock     = stock;
    }
    public String getProductId() { return productId; }
    public String getName()      { return name;      }
    public double getPrice()     { return price;     }
    public int    getStock()     { return stock;     }
    @Override
    public boolean validate() {
        return productId != null && !productId.isBlank()
            && name      != null && !name.isBlank()
            && price > 0
            && stock >= 0;
    }
    @Override
    public String getValidationReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ProductID : ").append(productId != null && !productId.isBlank() ? "[OK]" : "[FAIL] must not be empty").append("\n");
        sb.append("  Name      : ").append(name != null && !name.isBlank()           ? "[OK]" : "[FAIL] must not be empty").append("\n");
        sb.append("  Price     : ").append(price > 0  ? "[OK]" : "[FAIL] must be > 0").append("\n");
        sb.append("  Stock     : ").append(stock >= 0 ? "[OK]" : "[FAIL] must be >= 0").append("\n");
        return sb.toString();
    }
    @Override
    public String toString() {
        return "ProductComponent{id='" + productId + "', name='" + name + "', price=" + price + ", stock=" + stock + "}";
    }
}
