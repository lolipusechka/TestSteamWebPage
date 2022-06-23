package pages;
import service.UtilExplicitWaitForDriver;

public class PageOfTitle {

    private UtilExplicitWaitForDriver explicitWait = new UtilExplicitWaitForDriver();

    private String nameOfTitle = "//div[@id='appHubAppName']";
    private String dateOfRelease = "//div[@class='date']";
    private String priceOfTitle = "//div[@class='game_area_purchase_game_wrapper']//child::div[@data-price-final]";

    public String getNameOfTitle() {
        return explicitWait.findElement(nameOfTitle).getText();
    }

    public String getDateOfRelease() {
        return explicitWait.findElement(dateOfRelease).getText();
    }

    public String getPriceOfTitle() {
        return explicitWait.findElement(priceOfTitle).getAttribute("data-price-final");
    }

}