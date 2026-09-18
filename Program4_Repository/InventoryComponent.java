public class InventoryComponent implements Component {
    @Override
    public String getComponentName() {
        return "InventoryComponent";
    }
    @Override
    public String getComponentVersion() {
        return "1.3";
    }
    @Override
    public String getComponentDescription() {
        return "Manages product stock levels and reservations.";
    }
    public boolean checkStock(String productId) {
        System.out.println("  [InventoryComponent] Checking stock for: " + productId);
        return true;
    }
}
