package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    SoftAssert softAssert = new SoftAssert();

    protected WebDriver driver;
    private final String baseUrl = "https://jdi-testing.github.io/jdi-light/";

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void open(String path) {
        driver.get(baseUrl + path);
    }

    public void assertTitle(String title) {
        softAssert.assertEquals(driver.getTitle(), title);
    }

    public void loginAsUser(String username, String password) {
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    public void assertUserLoggined(String fullname) {
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), fullname);
    }

    public void selectCheckboxOrRadio(List<WebElement> elements, List<String> names) {
        for (WebElement element : elements) {
            for (String name : names) {
                if (element.getText().equals(name)) {
                    element.click();
                }
            }
        }
    }

    public void findTextInLog(String text) {
        driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/*[contains(text(), '"
                + text + "')]"));
    }

    public void assertElementText(By locator, String text) {
        softAssert.assertEquals(driver.findElement(locator).getText(),
                text);
    }

    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void assertAttributeValue(By locator, String attributeName, String value) {
        softAssert.assertEquals(driver.findElement(locator).getAttribute(attributeName),
                value);
    }

    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }
}
