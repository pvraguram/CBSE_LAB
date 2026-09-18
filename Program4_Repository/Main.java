public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Program 4: Component Repository (CBSE Lab)");
        System.out.println("=================================================");
        ComponentRepository repo = new ComponentRepository();
        System.out.println("\n[Registering components into repository...]");
        repo.register(new CalculatorComponent());
        repo.register(new PaymentComponent());
        repo.register(new InventoryComponent());
        System.out.println("\n[All registered components:]");
        repo.listAll();
        System.out.println("\n  Total components in repository: " + repo.getCount());
        System.out.println("\n[Looking up 'CalculatorComponent' by name...]");
        Component found = repo.findByName("CalculatorComponent");
        if (found != null) {
            System.out.println("  Found: " + found.getComponentName() + " v" + found.getComponentVersion());
            System.out.println("  Desc : " + found.getComponentDescription());
            CalculatorComponent calc = (CalculatorComponent) found;
            System.out.println("  calc.add(100, 250) = " + calc.add(100, 250));
        }
        System.out.println("\n[Looking up 'PaymentComponent' by name...]");
        Component pc = repo.findByName("PaymentComponent");
        if (pc != null) {
            ((PaymentComponent) pc).process("UPI", 750.00);
        }
        System.out.println("\n[Looking up unknown component 'ShippingComponent'...]");
        Component missing = repo.findByName("ShippingComponent");
        System.out.println("  Result: " + (missing == null ? "Not found in repository." : missing.getComponentName()));
    }
}
