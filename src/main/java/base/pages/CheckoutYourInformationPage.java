package base.pages;

import static base.custom.CustomConditions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutYourInformationPage {
    private final String firstNameInput = "first-name";
    private final String lastNameInput = "last-name";
    private final String zipInput = "postal-code";
    private final String continueButton = "continue";

    public void fillInformationInputs(String firstname, String lastname, String zip) {
        $(byId(firstNameInput)).shouldBe(inputCondition).append(firstname);
        $(byId(lastNameInput)).shouldBe(inputCondition).append(lastname);
        $(byId(zipInput)).shouldBe(inputCondition).append(zip);
    }

    public void clickContinueButton() {
        $(byId(continueButton)).shouldBe(clickable).click();
    }
}
