package base.pages;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ShoppingCartPage {
    private final String itemNames = "//div[@class='inventory_item_name']";
    private final String checkoutButton = "checkout";

    public List<String> getItemNamesText() {
        return $$(byXpath(itemNames)).shouldBe(CollectionCondition.sizeGreaterThan(0)).texts();
    }
    public void clickCheckoutButton(){
        $(byId(checkoutButton)).shouldBe(clickable).click();
    }
}
