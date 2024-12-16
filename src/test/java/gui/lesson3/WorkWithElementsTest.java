package gui.lesson3;

import base.config.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkWithElementsTest extends BaseTest {

//    @Test
    public void doubleClickTest(){
        $(byXpath("//p[@id='container-text']")).doubleClick();
    }

    @Test
    public void hoverTest(){
        $(byXpath("//nav[@class='nav-menu']/div[1]")).hover();
    }

    //    @Test
    public void downloadTest() throws IOException {
        File download = $(byXpath("(//h3/a)[1]")).scrollTo().download();

        String path = download.getPath();

        System.out.println(path);

//        FileUtils.deleteDirectory(new File("build/downloads"));
    }

    public static String getFilePath(String fileName) {
        return new File("src/main/resources/files/" + fileName).getAbsolutePath();
    }

//    @Test
    public void uploadFileTest() {
        $(byXpath("//input[@type='file']")).uploadFile(new File(getFilePath("annual-enterprise-survey-2023-financial-year-provisional.csv")));
    }

    //    @Test
    public void workWithElementsTest() {
        $(byXpath("//input[@placeholder='Username']")).append("standard_user");
//        $(byXpath("//input[@class='input_error form_input']")).clear();
//        $(byXpath("//input[@class='input_error form_input']")).append("test2");

//        $(byXpath("//input[@name='user-name']")).append("asd");

        $(byId("password")).append("secret_sauce");

//        $(byClassName("submit-button")).click();
//        $(byName("password")).append("asd");
//        $(byAttribute("placeholder", "Password")).append("asd");

//        $(byValue("Login")).submit();
//       $(byText("Sauce Labs Backpack")).click();
//        $(byTagName("input")).append("ads");

//            $(byCssSelector("#user-name")).append("asd");
//            $(byCssSelector(".input_error")).append("asd");
//            $(byCssSelector(".input_error.form_input")).append("asd");
//        $(byCssSelector("[data-test='username']")).append("asd");
//        $(byCssSelector("[placeholder='Username']")).append("asd");
//        $(byCssSelector("[type='text']")).append("asd");
//        $(byCssSelector("input")).append("+text2");

//        $(byCssSelector("#user-name.input_error.form_input")).append("asd");
//        $(byCssSelector("input.input_error")).append("asd");
//        $(byCssSelector("input[data-test='username'][placeholder='Username']")).append("asd");

//        Selenide.actions().sendKeys(Keys.ENTER).perform();

//        String value = $(byId("user-name")).getValue();
        $(byClassName("submit-button")).pressEnter();
//        for (int i = 0; i < value.length(); i++) {
//            Selenide.actions().sendKeys($(byId("user-name")),Keys.BACK_SPACE).perform();
//        }

//        $(byXpath("//select[@class='product_sort_container']")).click();

//        Selenide.sleep(2000);
//        $(byXpath("//select[@class='product_sort_container']")).pressEscape();
//        Selenide.actions().sendKeys(Keys.ESCAPE).perform();

//        ElementsCollection elementsCollection = $$(byXpath("//div[@class='inventory_item_name ']"));
//
//        String text = elementsCollection.get(0).text();
//
//        System.out.println(text);
//
//        List<String> texts = $$(byXpath("//div[@class='inventory_item_name ']")).texts();

//        elementsCollection.get(1).click();

//        ElementsCollection buttonsCollection = $$(byXpath("//button[text()='Add to cart']"));
//
//        while (buttonsCollection.size() > 0) {
//           $(byXpath("//button[text()='Add to cart']")).click();
//        }

        $(byXpath("//a[text()='Twitter']")).click();

        Selenide.switchTo().window(1);

        Selenide.sleep(3000);

        $(byXpath("//nav[@role='navigation']//a[@href='/settings']")).click();

        Selenide.closeWindow();

        Selenide.switchTo().window(0);

        ElementsCollection elementsCollection = $$(byXpath("//div[@class='inventory_item_name ']"));

        String text = elementsCollection.get(0).text();

        System.out.println(text);
    }
}
