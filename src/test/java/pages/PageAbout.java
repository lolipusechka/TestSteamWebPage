package pages;

import service.UtilExplicitWaitForDriver;

public class PageAbout {

    private UtilExplicitWaitForDriver explicitWait = new UtilExplicitWaitForDriver();

    private String aboutGreetingXpath = "//div[@id='about_greeting']";
    private String onlineUsersXpath = "//div[contains(@class, 'gamers_online')]/parent::div";
    private String inGameUsersXpath = "//div[contains(@class, 'gamers_in_game')]/parent::div";
    private String logoButtonXpath = "//span[@id='logo_holder']/a";

    public boolean isPageAbout() {
        return explicitWait.findElements(aboutGreetingXpath).size() > 0;
    }

    public int getOnlineUsersInt() {
        String numberStr = "0";
        for (char ch : explicitWait.findElement(onlineUsersXpath).getText().toCharArray()) {
            if (Character.getNumericValue(ch) < 10 && Character.getNumericValue(ch) >= 0) {
                numberStr += ch;
            }
        }
        return Integer.parseInt(numberStr);
    }

    public int getInGameUsersInt() {
        String numberStr = "0";
        for (char ch : explicitWait.findElement(inGameUsersXpath).getText().toCharArray()) {
            if (Character.getNumericValue(ch) < 10 && Character.getNumericValue(ch) >= 0) {
                numberStr += ch;
            }
        }
        return Integer.parseInt(numberStr);
    }

    public void clickOnLogoButton() {
        explicitWait.findElement(logoButtonXpath).click();
    }

}