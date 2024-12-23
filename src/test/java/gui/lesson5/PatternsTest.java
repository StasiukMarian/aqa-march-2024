package gui.lesson5;

import base.Pages;
import base.config.BaseTest;
import base.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import static base.Pages.*;
import static base.custom.Constants.*;

public class PatternsTest extends BaseTest {
    MainPage mainPage = new MainPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Test
    public void patternsTest() {
        loginPage().typeUsername(USERNAME);
        loginPage().typePassword(PASSWORD);
        loginPage().clickLoginButton();

        mainPage.waitMainPageLogo();

        String backPackItemFromMainPage = mainPage.getItemHeadersText().get(0);

        mainPage.clickAddToCartButton();
        mainPage.clickShoppingCartButton();

        String backPackItemFromShoppingCartPage = shoppingCartPage.getItemNamesText().get(0);

        Assert.assertEquals(backPackItemFromShoppingCartPage, backPackItemFromMainPage, "items are different");
        shoppingCartPage.clickCheckoutButton();

        checkoutYourInformationPage.fillInformationInputs(FIRST_NAME, LAST_NAME, ZIP);
        checkoutYourInformationPage.clickContinueButton();

        String backPackItemFromOverviewPage = checkoutOverviewPage.getItemNamesText().get(0);

        Assert.assertEquals(backPackItemFromOverviewPage, backPackItemFromMainPage, "items are different");
        checkoutOverviewPage.clickFinishButton();

        Assert.assertTrue(checkoutCompletePage.isCompleteHeaderVisible(), "Complete message is not visible");
        checkoutCompletePage.clickBackHomeButton();
    }
}
