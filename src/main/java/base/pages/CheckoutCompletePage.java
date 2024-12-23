package base.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutCompletePage {
    private final String completeHeader = "//h2[@class='complete-header']";
    private final String backHomeButton = "//button[text()='Back Home']";

    public boolean isCompleteHeaderVisible() {
        return $(byXpath(completeHeader)).is(visible);
    }

    public void clickBackHomeButton() {
        $(byXpath(backHomeButton)).shouldBe(clickable).click();
    }
}
