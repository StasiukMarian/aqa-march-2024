package gui.lesson7;

import base.config.BaseTest;
import base.custom.Constants;
import base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static base.Pages.*;
import static com.codeborne.selenide.Selenide.$;

public class DetailItemTest extends BaseTest {
    @Test
    public void detailTest() {
        loginPage().typeUsername(Constants.USERNAME);
        loginPage().typePassword(Constants.PASSWORD);
        loginPage().clickLoginButton();

        List<Item> itemsList = mainPage().getItemsList();

        mainPage().clickItemHeaderByPosition(3);

        Item detailedItem = detailItemPage().getDetailedItem();

        Assert.assertFalse(itemsList.contains(detailedItem), "List " + itemsList + " does not contains detailed item " + detailedItem);
    }
}
