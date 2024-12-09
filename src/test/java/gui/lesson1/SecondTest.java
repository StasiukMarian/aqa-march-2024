package gui.lesson1;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class SecondTest extends BaseTest {

    @Test(groups = {"test group"})
    public void firstTest() {
//        Selenide.open("https://www.google.com");
        System.out.println("It's our first test from Second class");
    }
    @Test
    public void secondTest() {
//        Selenide.open("https://www.google.com");
        System.out.println("It's our second test from Second class");
    }

}
