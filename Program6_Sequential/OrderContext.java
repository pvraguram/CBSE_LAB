public class OrderContext {
    private final String orderId;
    private final String product;
    private final double amount;
    private boolean paymentSuccess = false;
    private String receiptNumber = null;
    public OrderContext(String orderId, String product, double amount) {
        this.orderId = orderId;
        this.product = product;
        this.amount  = amount;
    }
    public String  getOrderId()       { return orderId;         }
    public String  getProduct()       { return product;         }
    public double  getAmount()        { return amount;          }
    public boolean isPaymentSuccess() { return paymentSuccess;  }
    public String  getReceiptNumber() { return receiptNumber;   }
    public void setPaymentSuccess(boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
}
