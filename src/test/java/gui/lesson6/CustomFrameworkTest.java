package gui.lesson6;

import base.config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static base.Pages.*;
import static base.custom.Constants.*;

public class CustomFrameworkTest extends BaseTest {
    @Test
    public void customTest() {
        loginPage().typeUsername(USERNAME);
        loginPage().typePassword(PASSWORD);
        loginPage().clickLoginButton();

//        mainPage().clickBurgerMenuButton();
//        mainPage().clickBurgerMenuItemByText("About");

        for (int i = 1; i <= mainPage().getItemHeaders().size(); i++) {

            mainPage().clickItemHeaderByPosition(i);
            detailItemPage().clickBackToProductsButton();

        }

    }
}
