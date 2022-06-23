package service;

public class SingletonUtilReadConfig {

    private static UtilReadConfig utilReadConfig = null;

    private SingletonUtilReadConfig() {}

    public static UtilReadConfig getInstanceOfUtilReadConfig() {
        if (utilReadConfig == null) {
            utilReadConfig = new UtilReadConfig();
        }
        return utilReadConfig;
    }

}