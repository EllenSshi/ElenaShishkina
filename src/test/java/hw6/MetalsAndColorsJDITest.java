package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.entities.MetalsAndColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw6.JDITestData.DEFAULT_USER;

public class MetalsAndColorsJDITest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JDITestSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "metalsAndColors", dataProviderClass = JDITestData.class)
    public void metalsAndColorsTest(MetalsAndColors metalColor) {
        JDITestSite.open();
        JDITestSite.indexPage.login(DEFAULT_USER);
        JDITestSite.indexPage.openPageFromMenu(JDITestSite.indexPage.metalsAndColors);
        JDITestSite.metalsAndColorsPage.metalsAndColorsForm.submit(metalColor);
        JDITestSite.metalsAndColorsPage.checkResult(metalColor);
        JDITestSite.metalsAndColorsPage.logout();
    }
}
