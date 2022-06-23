package test_cases;

import org.testng.annotations.Test;
import pages.PageHome;
import pages.PageOfTitle;
import pages.PageTopSellers;
import service.SingletonUtilReadConfigTests;

import java.util.ArrayList;

import static org.testng.AssertJUnit.*;

public class TestIsEqualsTheTitleInfoFromTopSellersPageAndTitlePage extends AbstractTestBase {

    @Test
    public void isEqualsTheTitleInfoFromTopSellersPageAndTitlePage() {
        PageHome pageHome = new PageHome();
        PageTopSellers pageTopSellers = new PageTopSellers();
        PageOfTitle pageOfTitle = new PageOfTitle();

        driver.get(SingletonUtilReadConfigTests.getInstanceOfUtilReadConfigTests().getUrl());

        assertTrue("<<It is not Home Page>>", pageHome.isPageHome());
        pageHome.clickOnButtonTopSellers();
        assertTrue("<<It is not Top Sellers Page>>", pageTopSellers.isPageTopSellers());
        pageTopSellers.clickOnCheckBoxAction();
        pageTopSellers.clickOnCheckBoxOs();
        pageTopSellers.clickOnCheckBoxNumbersOfPlayers();

        assertTrue("<<Check box OS is not selected>>",pageTopSellers.isCheckBoxOsSelected());
        assertTrue("<<Check box Numbers of Players is not selected>>",pageTopSellers.isCheckNumbersOfPlayersCoopSelected());
        assertTrue("<<Check box Tags is not selected>>",pageTopSellers.isCheckBoxTagsSelected());

        assertEquals("<<Count of titles from container are not equals count of title from result count>>",
                pageTopSellers.getCountOfTitleFromResultCount(), pageTopSellers.getCountOfTitleFromContainer());

        ArrayList<String> listOfTitlePropertiesFromPageTop = new ArrayList<>();
        listOfTitlePropertiesFromPageTop.add(pageTopSellers.getTopSellerTitle());
        listOfTitlePropertiesFromPageTop.add(pageTopSellers.getTopSellerDateReleased());
        listOfTitlePropertiesFromPageTop.add(pageTopSellers.getTopSellerPrice());

        pageTopSellers.clickOnButtonTopSellerTitle();

        ArrayList<String> listOfTitlePropertiesFromPageTitle = new ArrayList<>();
        listOfTitlePropertiesFromPageTitle.add(pageOfTitle.getNameOfTitle());
        listOfTitlePropertiesFromPageTitle.add(pageOfTitle.getDateOfRelease());
        listOfTitlePropertiesFromPageTitle.add(pageOfTitle.getPriceOfTitle());

        for (int i = 0; i < listOfTitlePropertiesFromPageTitle.size(); i++)
            assertEquals("<<Title info from Top Seller Page is not equals title info from Title Page>>", listOfTitlePropertiesFromPageTop.get(i), listOfTitlePropertiesFromPageTitle.get(i));
    }

}
