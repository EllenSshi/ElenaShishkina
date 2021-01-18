package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw6.JDITestSite.metalsAndColorsPage;
import static hw6.TestData.DEFAULT_USER;
import static hw6.JDITestSite.indexPage;
import static hw6.pages.IndexPage.*;
import static hw6.pages.MetalsAndColorsPage.submitForm;

public class MyJDITest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JDITestSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void metalsAndColorsTest() {
        indexPage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        indexPage.checkOpened();
        metalsAndColors.click();
        metalsAndColorsPage.checkOpened();

        submitForm.click();
    }
}
