package base.config;

import com.codeborne.selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PageTools {
    protected String locatorFormatter(String locator, Object... args) {
        return String.format(locator, args);
    }

    protected void shouldBe(String locatorType, WebElementCondition condition, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            case "id":
                $(byId(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            case "name":
                $(byName(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected void shouldHave(String locatorType, WebElementCondition condition, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).shouldHave(condition);
                break;
            case "id":
                $(byId(locatorFormatter(locator, args))).shouldHave(condition);
                break;
            case "name":
                $(byName(locatorFormatter(locator, args))).shouldHave(condition);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected void shouldCollection(String locatorType, WebElementsCondition condition, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $$(byXpath(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            case "id":
                $$(byId(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            case "name":
                $$(byName(locatorFormatter(locator, args))).shouldBe(condition);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected void click(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).click();
                break;
            case "id":
                $(byId(locatorFormatter(locator, args))).click();
                break;
            case "name":
                $(byName(locatorFormatter(locator, args))).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected void type(String locatorType, String text, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                $(byXpath(locatorFormatter(locator, args))).append(text);
                break;
            case "id":
                $(byId(locatorFormatter(locator, args))).append(text);
                break;
            case "name":
                $(byName(locatorFormatter(locator, args))).append(text);
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected String getText(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args))).getText();
            case "id":
                return $(byId(locatorFormatter(locator, args))).getText();
            case "name":
                return $(byName(locatorFormatter(locator, args))).getText();
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected ElementsCollection getElements(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $$(byXpath(locatorFormatter(locator, args)));
            case "id":
                return $$(byId(locatorFormatter(locator, args)));
            case "name":
                return $$(byName(locatorFormatter(locator, args)));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected List<String> getElementsText(String locatorType, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $$(byXpath(locatorFormatter(locator, args))).texts();
            case "id":
                return $$(byId(locatorFormatter(locator, args))).texts();
            case "name":
                return $$(byName(locatorFormatter(locator, args))).texts();
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }

    protected boolean isElementCondition(String locatorType, WebElementCondition condition, String locator, Object... args) {
        switch (locatorType) {
            case "xpath":
                return $(byXpath(locatorFormatter(locator, args))).is(condition);
            case "id":
                return $(byId(locatorFormatter(locator, args))).is(condition);
            case "name":
                return $(byName(locatorFormatter(locator, args))).is(condition);
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
}
