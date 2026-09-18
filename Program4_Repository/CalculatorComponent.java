public class CalculatorComponent implements Component {
    @Override
    public String getComponentName() {
        return "CalculatorComponent";
    }
    @Override
    public String getComponentVersion() {
        return "1.0";
    }
    @Override
    public String getComponentDescription() {
        return "Provides basic arithmetic: add, subtract, multiply, divide.";
    }
    public double add(double a, double b)      { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero.");
        return a / b;
    }
}
