package gui.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TasksTest {
    //    @Test
    public void progressBarTest() {
        Selenide.open("https://demoqa.com/progress-bar");

        $(byXpath("//button[@id='startStopButton']")).scrollTo().click();
        $(byXpath("//div[@role='progressbar']")).scrollTo();

        $(byXpath("//button[@id='resetButton']")).shouldBe(Condition.visible, Duration.ofSeconds(30));

        Assert.assertEquals($(byXpath("//div[@role='progressbar']")).text(), "100%");
        Assert.assertTrue($(byXpath("//button[@id='resetButton']")).is(Condition.visible));

//        while (true){
//            if ($(byXpath("//div[@role='progressbar']")).scrollTo().text().equals("50%")){
//                break;
//            }
//        }
//
//        $(byXpath("//button[@id='startStopButton']")).click();
//
//        Assert.assertEquals($(byXpath("//div[@role='progressbar']")).text(), "50%");
    }

    //    @Test
    public void alertsTest() {
        Selenide.open("https://demoqa.com/alerts");

//        $(byId("alertButton")).scrollTo().click();
//
//
//        String confirm = Selenide.confirm();
//
//        Assert.assertEquals(confirm, "You clicked a button");

        $(byId("confirmButton")).scrollTo().click();

        String dismiss = Selenide.dismiss();

        Assert.assertTrue($(byXpath("//span[text()='Cancel']")).is(Condition.visible));
    }

//    @Test
    public void shadowCssTest() {
        Selenide.open("http://uitestingplayground.com/shadowdom");

        $(shadowCss("#buttonGenerate", "guid-generator")).shouldBe(Condition.clickable).click();

        String textFromInput = $(shadowCss("#editField", "guid-generator")).shouldBe(Condition.not(Condition.empty)).getValue();

        $(shadowCss("#buttonCopy","guid-generator")).shouldBe(Condition.clickable).click();

        String textFromClipboard = clipboard().getText();

        Assert.assertEquals(textFromInput, textFromClipboard);
    }

    @Test
    public void iframeTest(){
        Selenide.open("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        Selenide.switchTo().frame("iframeResult");

        Selenide.switchTo().frame($(byXpath("//iframe[@title='W3Schools Free Online Web Tutorials']")));

        $(byXpath("//a[text()='CSS']")).shouldBe(Condition.visible).click();

    }
}
