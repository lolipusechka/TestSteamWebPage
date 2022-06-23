package service;

public class SingletonUtilReadConfigTests {

    private static UtilReadConfigTests utilReadConfigTests = null;

    private SingletonUtilReadConfigTests() {}

    public static UtilReadConfigTests getInstanceOfUtilReadConfigTests() {
        if (utilReadConfigTests == null) {
            utilReadConfigTests = new UtilReadConfigTests();
        }
        return utilReadConfigTests;
    }
}