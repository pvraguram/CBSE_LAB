public class LegacyPaymentAdapter implements PaymentComponent {
    private final LegacyPaymentGateway legacyGateway;
    public LegacyPaymentAdapter(LegacyPaymentGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }
    @Override
    public boolean makePayment(double amount, String recipient) {
        System.out.println("  [Adapter] Adapting PaymentComponent -> LegacyPaymentGateway");
        int amountInPaise = (int) (amount * 100);
        String accountCode = "ACC-" + recipient.toUpperCase().replace(" ", "_");
        String referenceId = "REF-" + System.currentTimeMillis();
        System.out.println("  [Adapter] Converted: Rs." + amount + " -> " + amountInPaise + " paise | recipient -> " + accountCode);
        String result = legacyGateway.initiateTransaction(amountInPaise, accountCode, referenceId);
        boolean success = result != null && result.contains("SUCCESS");
        System.out.println("  [Adapter] Legacy result: " + result + " -> success=" + success);
        return success;
    }
}
