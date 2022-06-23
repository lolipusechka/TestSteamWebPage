package test_cases;

import org.testng.annotations.Test;
import pages.PageAbout;
import pages.PageHome;
import service.SingletonUtilReadConfigTests;

import static org.testng.AssertJUnit.*;

public class TestCompareTheNumbersOfPlayers extends AbstractTestBase {

    @Test
    public void compareTheNumbersOfPlayers() {
        PageHome pageHome = new PageHome();
        PageAbout pageAbout = new PageAbout();
        driver.get(SingletonUtilReadConfigTests.getInstanceOfUtilReadConfigTests().getUrl());
        assertTrue("<<It is not Home Page of site>>", pageHome.isPageHome());
        pageHome.clickOnAboutButton();
        assertTrue("<<It is not About Page of site>>", pageAbout.isPageAbout());
        assertTrue("<<Online users are greater or equals playing now users>>",
                pageAbout.getOnlineUsersInt() >= pageAbout.getInGameUsersInt());
        pageAbout.clickOnLogoButton();
        assertTrue("<<It is not Home Page of site>>", pageHome.isPageHome());
    }

}