public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 5: Component Validation - Test Harness");
        System.out.println("=================================================");
        SimpleTestHarness harness = new SimpleTestHarness();
        System.out.println("\n[Test Suite 1: Valid ProductComponent]");
        ProductComponent laptop = new ProductComponent("P001", "Laptop Pro", 65000.00, 10);
        System.out.println("  Component: " + laptop);
        harness.validateComponent("Component self-validation (valid product)", laptop);
        harness.assertEqual("getProductId() == 'P001'",  "P001",      laptop.getProductId());
        harness.assertEqual("getName() == 'Laptop Pro'", "Laptop Pro", laptop.getName());
        harness.assertTrue("getPrice() > 0",             laptop.getPrice() > 0);
        harness.assertTrue("getStock() >= 0",            laptop.getStock() >= 0);
        System.out.println("\n[Test Suite 2: Invalid ProductComponent (bad data)]");
        ProductComponent bad = new ProductComponent("", "", -500.00, -3);
        System.out.println("  Component: " + bad);
        harness.assertFalse("Component self-validation (invalid product)", bad.validate());
        harness.assertTrue("Price is negative (expected failure)",  bad.getPrice() < 0);
        harness.assertTrue("Stock is negative (expected failure)",  bad.getStock() < 0);
        System.out.println("\n  Validation Report for invalid component:");
        System.out.println(bad.getValidationReport());
        System.out.println("[Test Suite 3: Zero-stock product (valid edge case)]");
        ProductComponent outOfStock = new ProductComponent("P002", "Sold-Out Item", 299.00, 0);
        harness.validateComponent("Zero stock product is still valid", outOfStock);
        harness.assertTrue("getStock() == 0", outOfStock.getStock() == 0);
        harness.printSummary();
    }
}
