public interface CartService {
    void addItem(String itemName, double price);
    void checkout(String paymentTarget);
    double getTotalAmount();
}
