public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Program 1: Calculator Component (CBSE Lab)");
        System.out.println("============================================");
        System.out.println();
        CalculatorComponent calc = new BasicCalculator();
        double a = 20, b = 4;
        System.out.println("Operands : a = " + a + ", b = " + b);
        System.out.println("------------------------------------------");
        System.out.printf("  %-14s : %.2f%n", "add(a, b)", calc.add(a, b));
        System.out.printf("  %-14s : %.2f%n", "subtract(a, b)", calc.subtract(a, b));
        System.out.printf("  %-14s : %.2f%n", "multiply(a, b)", calc.multiply(a, b));
        System.out.printf("  %-14s : %.2f%n", "divide(a, b)", calc.divide(a, b));
        System.out.println("------------------------------------------");
        System.out.println("\nAttempting divide by zero:");
        try {
            calc.divide(a, 0);
        } catch (ArithmeticException e) {
            System.out.println("  Exception caught: " + e.getMessage());
        }
    }
}
