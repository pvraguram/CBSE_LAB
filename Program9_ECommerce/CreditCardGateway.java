public class CreditCardGateway implements PaymentGateway, AppComponent {
    private final String maskedCard;
    public CreditCardGateway(String maskedCard) {
        this.maskedCard = maskedCard;
    }
    @Override
    public boolean pay(double amount, String merchant) {
        System.out.printf("    [Credit Card] Charging Rs.%.2f from %s -> '%s'%n", amount, maskedCard, merchant);
        return true;
    }
    @Override
    public String getMethodName()       { return "Credit Card (" + maskedCard + ")"; }
    @Override
    public String getComponentName()    { return "CreditCardGateway"; }
    @Override
    public String getComponentVersion() { return "1.0"; }
}
