package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    private final String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String title = "Home Page";

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

    public void open() {
        driver.get(baseUrl);
    }

    public void assertTitle() {
        softAssert.assertEquals(driver.getTitle(), title);
    }

    public void loginAsUser() {
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
    }

    public void assertUserLoggined() {
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    public void clickCheckboxOrRadio(List<WebElement> elements, List<String> names) {
        for (WebElement element : elements) {
            for (String name : names) {
                if (element.getText().equals(name)) {
                    element.click();
                }
            }
        }
    }
}
