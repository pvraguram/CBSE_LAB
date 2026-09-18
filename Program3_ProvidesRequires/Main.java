public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 3: Provides & Requires Interfaces (CBSE Lab)");
        System.out.println("=================================================");
        InventoryService inventory = new InventoryServiceImpl();
        OrderComponent order = new OrderComponent(inventory);
        System.out.println("\n[Using OrderComponent as ProductService]");
        ProductService ps = order;
        System.out.println("  " + ps.getProductDetails("P001"));
        System.out.println("  Price: Rs." + ps.getProductPrice("P001"));
        System.out.println("\n[Order 1 — In-stock product P001]");
        order.placeOrder("P001", 2);
        System.out.println("\n[Order 2 — Out-of-stock product P002]");
        order.placeOrder("P002", 1);
        System.out.println("\n[Order 3 — Another in-stock product P003]");
        order.placeOrder("P003", 3);
    }
}
