package base.config;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeGroups
    public void beforeGroup() {
        System.out.println("This method works before group");
    }

    @BeforeClass
    public void configuration() {
        System.out.println("this is before class");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x920";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

    }

    @BeforeMethod
    public void login() {
        System.out.println("This method works before each test method");
    }

    @AfterMethod
    public void logout() {
        System.out.println("This method works after each test method");
    }

    @AfterClass
    public void closeBrowser() {
        System.out.println("This method close browser");
    }

    @AfterGroups
    public void afterGroup() {
        System.out.println("This method works after group");
    }

}
