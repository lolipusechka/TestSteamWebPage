package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static service.SingletonDriver.getInstanceOfDriver;

public class UtilExplicitWaitForDriver {

    private final int timeOutInSeconds = SingletonUtilReadConfig.getInstanceOfUtilReadConfig().getTimeOutInSeconds();

    public WebElement findElement(String xpath) {
        return new WebDriverWait(getInstanceOfDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(webDriver -> getInstanceOfDriver().findElement(By.xpath(xpath)));
    }

    public List<WebElement> findElements(String xpath) {
        return new WebDriverWait(getInstanceOfDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(webDriver -> getInstanceOfDriver().findElements(By.xpath(xpath)));
    }
}