public class ECommerceApp {
    public static void main(String[] args) {
        separator("Program 9: E-Commerce Application using Reusable Components");
        ProductCatalogImpl catalog = new ProductCatalogImpl();
        StockServiceImpl stock = new StockServiceImpl();
        PricingComponent pricing = new PricingComponent();
        UPIGateway upi = new UPIGateway("customer@oksbi");
        CreditCardGateway card = new CreditCardGateway("5200-XXXX-XXXX-4321");
        System.out.println("\n[1] Component Registry - Registering all components:");
        ComponentRegistry registry = new ComponentRegistry();
        registry.register(catalog);
        registry.register(stock);
        registry.register(pricing);
        registry.register(upi);
        registry.register(card);
        registry.register(new OrderManager(catalog, stock));
        registry.printAll();
        OrderManager orderManager = new OrderManager(catalog, stock);
        ShoppingCartComponent cart = new ShoppingCartComponent(catalog, pricing, upi);
        System.out.println("\n[2] Order Validation:");
        orderManager.confirmOrder("EC002", 2);
        orderManager.confirmOrder("EC004", 1);
        orderManager.confirmOrder("EC999", 1);
        System.out.println("\n[3] Shopping Cart Checkout with UPI:");
        cart.addToCart("EC001", 1);
        cart.addToCart("EC003", 2);
        cart.checkout(10.0, "estore@merchant");
        System.out.println("\n[4] Swapping Payment: UPI -> Credit Card:");
        ShoppingCartComponent cart2 = new ShoppingCartComponent(catalog, pricing, card);
        cart2.addToCart("EC002", 1);
        cart2.checkout(5.0, "estore@merchant");
    }
    private static void separator(String title) {
        int w = 60;
        String line = "=".repeat(w);
        System.out.println(line);
        System.out.printf(" %-58s%n", title);
        System.out.println(line);
    }
}
