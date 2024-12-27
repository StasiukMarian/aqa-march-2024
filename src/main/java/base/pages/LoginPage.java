package base.pages;

import base.config.PageTools;

import static base.custom.CustomConditions.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage extends PageTools {
    private final String usernameInput = "//input[@placeholder='Username']";
    private final String usernameInputByPlaceholder = "//input[@placeholder='%s']";
    private final String passwordInput = "password";
    private final String loginButton = "login-button";

    public void typeUsername(String username) {
        shouldBe("xpath", inputCondition, usernameInput);
        type("xpath", username, usernameInput);
    }

    public void typeUsernameByPlaceholder(String username, String placeholderValue) {
        shouldBe("xpath", inputCondition, usernameInputByPlaceholder, placeholderValue);
        type("xpath", username, usernameInputByPlaceholder, placeholderValue);
    }

    public void typePassword(String password) {
        shouldBe("id", inputCondition, passwordInput);
        type("id", password, passwordInput);
    }

    public void clickLoginButton() {
        shouldBe("id", clickable, loginButton);
        click("id", loginButton);
    }
}
