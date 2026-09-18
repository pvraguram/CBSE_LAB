public class UPIGateway implements PaymentGateway, AppComponent {
    private final String upiId;
    public UPIGateway(String upiId) {
        this.upiId = upiId;
    }
    @Override
    public boolean pay(double amount, String merchant) {
        System.out.printf("    [UPI] Rs.%.2f from '%s' -> '%s'%n", amount, upiId, merchant);
        return true;
    }
    @Override
    public String getMethodName()       { return "UPI (" + upiId + ")"; }
    @Override
    public String getComponentName()    { return "UPIGateway"; }
    @Override
    public String getComponentVersion() { return "2.0"; }
}
