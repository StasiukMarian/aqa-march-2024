package base.pages;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final String itemNames = "//div[@class='inventory_item_name']";
    private final String finishButton = "finish";

    public List<String> getItemNamesText(){
        return $$(byXpath(itemNames)).shouldBe(CollectionCondition.sizeGreaterThan(0)).texts();
    }
    public void clickFinishButton(){
        $(byId(finishButton)).shouldBe(clickable).click();
    }
}
