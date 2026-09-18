public class LegacyPaymentGateway {
    public String initiateTransaction(int amountInPaise, String accountCode, String referenceId) {
        System.out.println("  [Legacy Gateway] initiateTransaction() called");
        System.out.println("    Amount (paise) : " + amountInPaise);
        System.out.println("    Account Code   : " + accountCode);
        System.out.println("    Reference ID   : " + referenceId);
        return "TXN-SUCCESS-" + referenceId;
    }
}
