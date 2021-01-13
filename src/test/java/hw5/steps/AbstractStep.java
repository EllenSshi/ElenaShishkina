package hw5.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import hw3.pages.UserTablePage;
import hw5.services.driver.WebDriverSingleton;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AbstractStep {

    IndexPage indexPage;
    DifferentElementsPage difElementsPage;
    UserTablePage userTablePage;
    SoftAssert softAssert;

    protected AbstractStep() {
        WebDriver driver = WebDriverSingleton.getDriver();
        indexPage = new IndexPage(driver);
        difElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
        softAssert = new SoftAssert();
    }
}
