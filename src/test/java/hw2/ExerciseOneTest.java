package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class ExerciseOneTest extends AbstractTest {
    @Test
    public void testFirstExercise() {
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
        softAssert.assertEquals(driver.findElement(By.cssSelector(".nav a[href='index.html']")).getText(),
                "HOME");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".nav a[href='contacts.html']")).getText(),
                "CONTACT FORM");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".nav .dropdown")).getText(), "SERVICE");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".nav a[href='metals-colors.html']")).getText(),
                "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit > .benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit > .benefit-txt"));
        softAssert.assertEquals(texts.size(), 4);
        softAssert.assertEquals(texts.get(0).getText(),
                "To include good practices\nand ideas from successful\nEPAM project");
        softAssert.assertEquals(texts.get(1).getText(), "To be flexible and\ncustomizable");
        softAssert.assertEquals(texts.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(texts.get(3).getText(),
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        //8. Assert that there is the iframe with “Frame Button” exist
        driver.switchTo().frame("frame");
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertEquals(driver.findElement(By.id("frame-button")).getAttribute("value"),
                "Frame Button");
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(driver.findElement(By.cssSelector(".sidebar-menu > li[index='1'] span")).getText(),
                "Home");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".sidebar-menu > li[index='2'] span")).getText(),
                "Contact form");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".sidebar-menu > li[index='3'] span")).getText(),
                "Service");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".sidebar-menu > li[index='4'] span")).getText(),
                "Metals & Colors");
        softAssert.assertEquals(driver.findElement(By.cssSelector(".sidebar-menu > li[index='5'] span")).getText(),
                "Elements packs");
        softAssert.assertAll();
    }
}
