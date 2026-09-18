public class SimpleTestHarness {
    private int passed = 0;
    private int failed = 0;
    public void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("  [PASS] " + testName);
            passed++;
        } else {
            System.out.println("  [FAIL] " + testName);
            failed++;
        }
    }
    public void assertFalse(String testName, boolean condition) {
        assertTrue(testName, !condition);
    }
    public void assertEqual(String testName, Object expected, Object actual) {
        boolean ok = expected != null && expected.equals(actual);
        if (ok) {
            System.out.println("  [PASS] " + testName);
            passed++;
        } else {
            System.out.println("  [FAIL] " + testName + "  |  expected: " + expected + "  |  got: " + actual);
            failed++;
        }
    }
    public void validateComponent(String testName, Validatable component) {
        boolean valid = component.validate();
        if (valid) {
            System.out.println("  [PASS] " + testName + " - component.validate() = true");
            passed++;
        } else {
            System.out.println("  [FAIL] " + testName + " - component.validate() = false");
            System.out.println("         Validation Report:");
            for (String line : component.getValidationReport().split("\n")) {
                System.out.println("         " + line);
            }
            failed++;
        }
    }
    public void printSummary() {
        int total = passed + failed;
        System.out.println();
        System.out.println("  =================== Test Summary ===================");
        System.out.println("  Tests Run  : " + total);
        System.out.println("  Passed     : " + passed);
        System.out.println("  Failed     : " + failed);
        System.out.println("  Result     : " + (failed == 0 ? "ALL PASS" : failed + " FAILURE(S)"));
        System.out.println("  =====================================================");
    }
}
