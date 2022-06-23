package pages;

import service.UtilExplicitWaitForDriver;

public class PageHome {

    private UtilExplicitWaitForDriver explicitWait = new UtilExplicitWaitForDriver();

    private String homePageBodyXpath = "//div[contains(@class, 'home_page_body')]";
    private String popUpMenuNewAndNoteworthyXpath = "//span[@class='pulldown']//child::a[contains(text(), 'New') and @class='pulldown_desktop']";
    private String buttonTopSellersXpath = "//div[@id='noteworthy_flyout']//child::a[contains(@href, 'topsellers')]";
    private String buttonAboutXpath = "//div[@class='supernav_container']/a[contains(@href, 'about')]";

    public boolean isPageHome() {
        return explicitWait.findElements(homePageBodyXpath).size() > 0;
    }

    public void clickOnAboutButton() {
        explicitWait.findElement(buttonAboutXpath).click();
    }

    public void clickOnButtonTopSellers() {
        explicitWait.findElement(popUpMenuNewAndNoteworthyXpath).click();
        explicitWait.findElement(buttonTopSellersXpath).click();
    }
}