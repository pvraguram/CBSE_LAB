import java.util.HashMap;
import java.util.Map;

public class ProductCatalogImpl implements ProductCatalog, AppComponent {
    private final Map<String, String[]> products = new HashMap<>();
    public ProductCatalogImpl() {
        products.put("EC001", new String[]{"Laptop Pro 15\"", "75000.00"});
        products.put("EC002", new String[]{"Wireless Headphones", "3500.00"});
        products.put("EC003", new String[]{"Mechanical Keyboard", "4500.00"});
        products.put("EC004", new String[]{"USB-C Hub", "1800.00"});
    }
    @Override
    public String getProductName(String productId) {
        String[] p = products.get(productId);
        return p != null ? p[0] : null;
    }
    @Override
    public double getUnitPrice(String productId) {
        String[] p = products.get(productId);
        return p != null ? Double.parseDouble(p[1]) : 0.0;
    }
    @Override
    public boolean exists(String productId) {
        return products.containsKey(productId);
    }
    @Override
    public String getComponentName()    { return "ProductCatalog"; }
    @Override
    public String getComponentVersion() { return "1.2"; }
}
