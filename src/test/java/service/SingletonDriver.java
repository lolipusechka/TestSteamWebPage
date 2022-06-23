package service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonDriver {

    private static WebDriver driver;

    private SingletonDriver() {}

    public static WebDriver getInstanceOfDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=" + SingletonUtilReadConfig.getInstanceOfUtilReadConfig().getWindowSize());
            options.addArguments("--lang=" + SingletonUtilReadConfig.getInstanceOfUtilReadConfig().getLanguage());
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void setInstanceOfDriverNull() {
        driver.quit();
        driver = null;
    }

}