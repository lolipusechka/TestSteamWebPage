package test_cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import service.SingletonDriver;

//package-private
abstract class AbstractTestBase {

    protected WebDriver driver;

    @BeforeMethod
    protected void init() {
        driver = SingletonDriver.getInstanceOfDriver();
    }

    @AfterMethod
    protected void tearDown() {
        SingletonDriver.setInstanceOfDriverNull();
    }

}