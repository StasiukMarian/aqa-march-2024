package base.pages;

import static base.custom.CustomConditions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final String usernameInput = "//input[@placeholder='Username']";
    private final String passwordInput = "password";
    private final String loginButton = "login-button";

    public void typeUsername(String username) {
        $(byXpath(usernameInput)).shouldBe(inputCondition).append(username);
    }

    public void typePassword(String password) {
        $(byId(passwordInput)).shouldBe(inputCondition).append(password);
    }

    public void clickLoginButton() {
        $(byName(loginButton)).shouldBe(clickable).click();
    }
}
