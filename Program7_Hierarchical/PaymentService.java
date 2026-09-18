public interface PaymentService {
    boolean pay(double amount, String to);
    String getMethodName();
}
