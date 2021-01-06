package hw4.steps;

import hw3.pages.AbstractPage;
import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractStep {

    IndexPage indexPage;
    DifferentElementsPage difElementsPage;
    SoftAssert softAssert;

    protected AbstractStep(WebDriver driver) {
        indexPage = new IndexPage(driver);
        difElementsPage = new DifferentElementsPage(driver);
        softAssert = new SoftAssert();
    }

    @Step("Open Index Page")
    public void openIndexPage() {
        indexPage.open();
    }

    @Step("Go to Different Elements Page from Index Page")
    public void goToDifferentElementsPage() {
        indexPage.goToDifferentElementsPage();
    }

    @Step("Login as '{username}' from Index Page")
    public void loginAsUserFromIndexPage(String username, String password) {
        indexPage.loginAsUser(username, password);
    }
}
