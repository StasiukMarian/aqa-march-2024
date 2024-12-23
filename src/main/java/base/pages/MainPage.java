package base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String appLogo = "//div[@class='app_logo']";
    private final String itemHeaders = "//div[@class='inventory_item_name ']";
    private final String addToCartButton = "//button[text()='Add to cart']";
    private final String shoppingCartButton = "//a[@class='shopping_cart_link']";

    public void waitMainPageLogo() {
        $(byXpath(appLogo)).shouldBe(visible, Duration.ofSeconds(30));
    }

    public ElementsCollection getItemHeaders() {
        return $$(byXpath(itemHeaders)).shouldBe(CollectionCondition.size(6));
    }

    public List<String> getItemHeadersText() {
        return $$(byXpath(itemHeaders)).shouldBe(CollectionCondition.size(6)).texts();
    }
    public void clickAddToCartButton(){
        $(byXpath(addToCartButton)).shouldBe(clickable).click();
    }
    public void clickShoppingCartButton(){
        $(byXpath(shoppingCartButton)).shouldBe(clickable).click();
    }
}
