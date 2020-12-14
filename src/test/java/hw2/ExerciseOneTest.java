package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ExerciseOneTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        //12. Close Browser
        if (driver != null) {
            driver.quit();
        }
    }

    //All elements should have proper waits
    @Test
    public void test() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        //3. Perform login
        driver.findElement(By.className("profile-photo")).click();
        driver.findElements(By.id("name")).get(0).sendKeys("Roman");
        driver.findElements(By.id("password")).get(0).sendKeys("Jdi1234");
        driver.findElements(By.id("login-button")).get(0).click();
        //4. Assert Username is loggined
        softAssert.assertEquals(driver.findElements(By.id("user-name")).get(0).getText(), "ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        driver.findElement(By.linkText("Home"));
        driver.findElement(By.linkText("Contact form"));
        driver.findElement(By.partialLinkText("Service"));
        driver.findElement(By.linkText("Metals & Colors"));
        //6. Assert that there are 4 images on the Index Page and they are displayed
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //8. Assert that there is the iframe with “Frame Button” exist
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //10. Switch to original window back
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text

        Thread.sleep(50);

        softAssert.assertAll();
    }
}
