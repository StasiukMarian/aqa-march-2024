package base.pages;

import base.config.PageTools;

import static com.codeborne.selenide.Condition.clickable;

public class DetailItemPage extends PageTools {
    private final String backToProductsButton = "back-to-products";

    public void clickBackToProductsButton() {
        shouldBe("id", clickable, backToProductsButton);
        click("id", backToProductsButton);
    }

}
