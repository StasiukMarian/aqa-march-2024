package base;

import base.pages.DetailItemPage;
import base.pages.LoginPage;
import base.pages.MainPage;

public class Pages {
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static DetailItemPage detailItemPage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static DetailItemPage detailItemPage() {
        if (detailItemPage == null) {
            detailItemPage = new DetailItemPage();
        }
        return detailItemPage;
    }
}
