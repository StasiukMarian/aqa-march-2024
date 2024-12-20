package gui.lesson4;

import base.config.BaseTest;
import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AssertionsTest extends BaseTest {

    @Test
    public void checkboxes() {
//        $(byXpath("//input[@type='checkbox'][1]")).click();
//
//        Assert.assertTrue($(byXpath("//input[@type='checkbox'][1]")).is(checked), "checkbox is not checked");
//        $(byXpath("//input[@type='checkbox'][1]")).shouldBe(checked);

        ElementsCollection checkboxes = $$(byXpath("//input[@type='checkbox']"));

        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).shouldBe(visible).click();
            Assert.assertTrue(checkboxes.get(i).is(checked), "checkbox is not checked");
        }
        $(byXpath("//input[@name='num']")).shouldHave(value("100"));

        Assert.assertEquals($(byXpath("//input[@name='num']")).getValue(), "100", "value is not 100");
    }

    //    @Test
    public void assertionsTest() {
        WebElementCondition inputCondition = and("input condition", empty, visible);

        $(byXpath("//input[@placeholder='Username']")).shouldBe(inputCondition, Duration.ofSeconds(30)).append("standard_user");
        $(byXpath("//input[@placeholder='Password']")).shouldBe(inputCondition, Duration.ofSeconds(30)).append("secret_sauce");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(id("user-name")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(cssClass("input_error")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(attribute("data-test", "username")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(name("user-name")).append("asd");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(name("user-name")).append("asd");
//        System.out.println($(byXpath("//h3[@data-test='error']")).is(exist));

//        $(byXpath("//input[@placeholder='Username']")).shouldBe(not(hidden)).append("asd");

//        $(byXpath("//input[@type='submit']")).shouldBe(enabled).shouldNotHave(value("Login")).click();
        $(byXpath("//input[@type='submit']")).shouldBe(enabled).shouldHave(value("Login")).click();


//        System.out.println($(byXpath("//h3[@data-test='error']")).is(exist));


//        String text = $(byXpath("//div[@class='login_logo']")).shouldBe(exist).shouldHave(text("swag")).getText();

//        System.out.println(text);


        $(byXpath("//div[@class='app_logo']")).shouldBe(visible);

//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.empty).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeNotEqual(0)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeGreaterThan(5)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeLessThanOrEqual(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeLessThan(7)).texts());


//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.texts(List.of("sauce Labs", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.textsInAnyOrder(List.of("sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket","Test.allTheThings() T-Shirt (Red)" ,"Sauce Labs Onesie"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.exactTexts(List.of("sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.exactTextsCaseSensitive(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.itemWithText("Sauce Labs Onesie")).texts());

        SelenideElement appLogo = $(byXpath("//div[@class='app_logo']"));
        boolean isAppLogoVisible = $(byXpath("//div[@class='app_logo']")).is(visible);

        Assert.assertEquals(appLogo.getText(), "Swag Labs", "items are not equal");

//        Assert.assertFalse(isAppLogoVisible, "logo is not visible");
        Assert.assertTrue(isAppLogoVisible, "logo is not visible");

        Assert.assertTrue(appLogo.getText().contains("Labs"), "logo doesn't contain expected text");

        ElementsCollection itemsCollection = $$(byXpath("//div[@class='inventory_item_name ']"));

        Assert.assertFalse(itemsCollection.isEmpty(), "list is empty");

        Assert.assertEquals(itemsCollection.size(), 6, "list size is not 6");

        List<String> expectedItemCollection = List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");

        Assert.assertEquals(itemsCollection.texts(), expectedItemCollection, "collections are not equal");

        Assert.assertTrue(itemsCollection.texts().contains("Sauce Labs Bike Light"), "collection doesn't have this item");
    }
}
