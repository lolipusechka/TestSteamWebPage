package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import service.SingletonUtilReadConfig;
import service.UtilExplicitWaitForDriver;

import static service.SingletonUtilReadConfigTests.getInstanceOfUtilReadConfigTests;
import static service.SingletonDriver.getInstanceOfDriver;

import java.util.List;

public class PageTopSellers {

    private UtilExplicitWaitForDriver explicitWait = new UtilExplicitWaitForDriver();
    Actions actions = new Actions(getInstanceOfDriver());

    private String headerOfTopSellerPage = "//h2[contains(@class,'pageheader') and contains(text(), 'Top Sellers')]";

    private String osFilterBlock = "//div[@data-collapse-name='os']//div[@class='block_header']";
    private String isOsBoxCollapsed = "//div[contains(@class,'collapsed') and @data-collapse-name='os']";
    private String isCheckBoxOsSelected = "//div[contains(@class, 'checked') and @data-param='os']";

    private String numberOfPlayersBlock = "//div[@data-collapse-name='category3']//div[@class='block_header']";
    private String isNumberOfPlayersBoxCollapsed = "//div[contains(@class,'collapsed') and @data-collapse-name='category3']";
    private String isCheckBoxNumbersOfPlayersSelected = "//div[contains(@class,'checked') and @data-param='category3']";

    private String tagsBlock = "//div[@data-collapse-name='tags']//div[contains(@class,'block_header')]";
    private String iSTagsBoxCollapsed = "//div[contains(@class,'collapsed') and @data-collapse-name='tags']";
    private String seeAllExpanderTags = "//div[contains(@class,'search_collapse_block') and @data-collapse-name='tags']//a[@class='see_all_expander']";
    private String isCheckBoxTagsSelected = "//div[contains(@class,'checked') and @data-param='tags']";

    private String topSellerTitle = "//div[@id='search_result_container']//a[1]//span[@class='title']";
    private String topSellerDateReleased = "//div[@id='search_result_container']//a[1]//div[contains(@class,'col search_released')]";
    private String topSellerPrice = "//div[@id='search_result_container']//a[1]//div[@data-price-final]";

    private String buttonTopSellerTitle = "//div[@id='search_resultsRows']/a[1]";

    private String isRefreshed = "//div[@id='search_results_loading' and @style='display: none;']";

    private String searchResultContainer = "//div[@id='search_result_container']//a";
    private String searchResultCount = "//div[@class='search_results_count']";

    private String checkBoxOs = "//div[@data-loc='" + getInstanceOfUtilReadConfigTests()
            .getCheckBoxOs() + "']//span[@class='tab_filter_control_checkbox']";

    private String checkBoxByNumberOfPlayers = "//div[@data-loc='" + getInstanceOfUtilReadConfigTests()
            .getCheckBoxByNumberOfPlayers() + "']//span[@class='tab_filter_control_checkbox']";

    private String checkBoxByTag = "//div[@data-loc='" + getInstanceOfUtilReadConfigTests()
            .getCheckBoxByTag() + "']//span[@class='tab_filter_control_checkbox']";

    public boolean isPageTopSellers() {
        return explicitWait.findElements(headerOfTopSellerPage).size() > 0;
    }

    public void clickOnCheckBoxOs() {
        clickOnBoxCollapsed();
        actions.click(explicitWait.findElement(checkBoxOs));
        actions.pause(SingletonUtilReadConfig.getInstanceOfUtilReadConfig().getPauseInMilliSeconds());
        actions.perform();
    }

    public boolean isCheckBoxOsSelected() {
        return !ExpectedConditions.invisibilityOfElementLocated(By.xpath(isCheckBoxOsSelected))
                .apply(getInstanceOfDriver());
    }

    public void clickOnCheckBoxNumbersOfPlayers() {
        clickOnBoxCollapsed();
        actions.click(explicitWait.findElement(checkBoxByNumberOfPlayers));
        actions.pause(SingletonUtilReadConfig.getInstanceOfUtilReadConfig().getPauseInMilliSeconds());
        actions.perform();
    }

    public boolean isCheckNumbersOfPlayersCoopSelected() {
        return !ExpectedConditions.invisibilityOfElementLocated(By.xpath(isCheckBoxNumbersOfPlayersSelected)).apply(getInstanceOfDriver());
    }

    public void clickOnCheckBoxAction() {
        clickOnBoxCollapsed();
        actions.click(explicitWait.findElement(seeAllExpanderTags)).click(explicitWait.findElement(checkBoxByTag));
        actions.pause(SingletonUtilReadConfig.getInstanceOfUtilReadConfig().getPauseInMilliSeconds());
        actions.perform();
    }

    public boolean isCheckBoxTagsSelected() {
        return !ExpectedConditions.invisibilityOfElementLocated(By.xpath(isCheckBoxTagsSelected)).apply(getInstanceOfDriver());
    }

    public int getCountOfTitleFromContainer() {
        int result = 0;
        List<WebElement> list = explicitWait.findElements(searchResultContainer);
        result = list.size();
        return result;
    }

    public int getCountOfTitleFromResultCount() {
        String numberStr = "";
        for (char ch : explicitWait.findElement(searchResultCount).getText().toCharArray()) {
            if (Character.getNumericValue(ch) < 10 && Character.getNumericValue(ch) >= 0) {
                numberStr += ch;
            }
        }
        return Integer.parseInt(numberStr);
    }

    public String getTopSellerTitle() {
        String result = "";
            result = explicitWait.findElement(topSellerTitle).getText();
        return result;
    }

    public String getTopSellerDateReleased() {
        String result = "";
            result = explicitWait.findElement(topSellerDateReleased).getText();
        return result;
    }

    public String getTopSellerPrice() {
        String result = "";
            result = explicitWait.findElement(topSellerPrice).getAttribute("data-price-final");
        return result;
    }

    public void clickOnButtonTopSellerTitle() {
        explicitWait.findElement(buttonTopSellerTitle).click();
    }

    private void clickOnBoxCollapsed() {
        if (!ExpectedConditions.invisibilityOfElementLocated(By.xpath(iSTagsBoxCollapsed)).apply(getInstanceOfDriver())) {
            explicitWait.findElement(tagsBlock).click();
        } else if (!ExpectedConditions.invisibilityOfElementLocated(By.xpath(isOsBoxCollapsed)).apply(getInstanceOfDriver())) {
            explicitWait.findElement(osFilterBlock).click();
        } else if (!ExpectedConditions.invisibilityOfElementLocated(By.xpath(isNumberOfPlayersBoxCollapsed)).apply(getInstanceOfDriver())) {
            explicitWait.findElement(numberOfPlayersBlock).click();
        }
    }
}