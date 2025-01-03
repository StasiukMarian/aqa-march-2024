package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends PageTools {
    private final String appLogo = "//div[@class='app_log']";
    private final String itemHeaders = "//div[@class='inventory_item_name ']";
    private final String itemDescriptions = "//div[@class='inventory_item_desc']";
    private final String itemPrices = "//div[@class='inventory_item_price']";
    private final String itemHeadersByPosition = "(//div[@class='inventory_item_name '])[%d]";
    private final String addToCartButton = "//button[text()='Add to cart']";
    private final String shoppingCartButton = "//a[@class='shopping_cart_link']";
    private final String burgerMenuButton = "react-burger-menu-btn";
    private final String burgerMenuItemByText = "//nav[@class='bm-item-list']/a[text()='%s']";

    public void waitMainPageLogo() {
        $(byXpath(appLogo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    public List<Item> getItemsList() {
        List<Item> items = new ArrayList<>();

        List<String> headersList = getElementsText("xpath", itemHeaders);
        List<String> descriptionsList = getElementsText("xpath", itemDescriptions);
        List<String> pricesList = getElementsText("xpath", itemPrices);

        for (int i = 0; i < headersList.size(); i++) {
            Item item = new Item();

            item.setName(headersList.get(i));
            item.setDescription(descriptionsList.get(i));
            item.setPrice(pricesList.get(i));

            items.add(item);
        }
        return items;
    }

    public ElementsCollection getItemHeaders() {
        shouldCollection("xpath", CollectionCondition.size(6), itemHeaders);
        return getElements("xpath", itemHeaders);
    }

    public void clickItemHeaderByPosition(int position) {
        shouldBe("xpath", clickable, itemHeadersByPosition, position);
        click("xpath", itemHeadersByPosition, position);
    }

    public List<String> getItemHeadersText() {
        shouldCollection("xpath", CollectionCondition.size(6), itemHeaders);
        return getElementsText("xpath", itemHeaders);
    }

    public void clickAddToCartButton() {
        $(byXpath(addToCartButton)).shouldBe(clickable).click();
    }

    public void clickShoppingCartButton() {
        $(byXpath(shoppingCartButton)).shouldBe(clickable).click();
    }

    public void clickBurgerMenuButton() {
        shouldBe("id", clickable, burgerMenuButton);
        click("id", burgerMenuButton);
    }

    public void clickBurgerMenuItemByText(String text) {
        shouldBe("xpath", clickable, burgerMenuItemByText, text);
        click("xpath", burgerMenuItemByText, text);
    }

    public boolean isAppLogoVisible() {
        return isElementCondition("xpath", visible, appLogo);
    }
}
