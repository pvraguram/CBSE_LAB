import java.util.HashMap;
import java.util.Map;

public class StockServiceImpl implements StockService, AppComponent {
    private final Map<String, Integer> stock = new HashMap<>();
    public StockServiceImpl() {
        stock.put("EC001", 5);
        stock.put("EC002", 20);
        stock.put("EC003", 8);
        stock.put("EC004", 0);
    }
    @Override
    public boolean inStock(String productId, int quantity) {
        return stock.getOrDefault(productId, 0) >= quantity;
    }
    @Override
    public void reserve(String productId, int quantity) {
        stock.computeIfPresent(productId, (id, current) -> current - quantity);
    }
    @Override
    public String getComponentName()    { return "StockService"; }
    @Override
    public String getComponentVersion() { return "1.0"; }
}
