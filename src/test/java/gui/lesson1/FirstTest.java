package gui.lesson1;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest {

    @Test(groups = {"test group"})
    public void firstTest(){
//        Selenide.open("https://www.google.com");
        System.out.println("This is first test from first class");
    }
}
