package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class ExerciseOneTest extends AbstractTest {

    @Test
    public void testFirstExercise() {
        //1. Open test site by URL
        open("index.html");
        //2. Assert Browser title
        assertTitle("Home Page");
        //3. Perform login
        loginAsUser("Roman", "Jdi1234");
        //4. Assert Username is loggined
        assertUserLoggined("ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertElementText(By.cssSelector(".nav a[href='index.html']"), "HOME");
        assertElementText(By.cssSelector(".nav a[href='contacts.html']"), "CONTACT FORM");
        assertElementText(By.cssSelector(".nav .dropdown"), "SERVICE");
        assertElementText(By.cssSelector(".nav a[href='metals-colors.html']"), "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit > .benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertElementText(By.cssSelector(".benefits .col-sm-3:nth-child(1) .benefit-txt"),
                "To include good practices\nand ideas from successful\nEPAM project");
        assertElementText(By.cssSelector(".benefits .col-sm-3:nth-child(2) .benefit-txt"),
                "To be flexible and\ncustomizable");
        assertElementText(By.cssSelector(".benefits .col-sm-3:nth-child(3) .benefit-txt"), "To be multiplatform");
        assertElementText(By.cssSelector(".benefits .col-sm-3:nth-child(4) .benefit-txt"),
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        //8. Assert that there is the iframe with “Frame Button” exist
        switchToFrame("frame");
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertAttributeValue(By.id("frame-button"), "value", "Frame Button");
        //10. Switch to original window back
        switchToDefault();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertElementText(By.cssSelector(".sidebar-menu > li[index='1'] span"), "Home");
        assertElementText(By.cssSelector(".sidebar-menu > li[index='2'] span"), "Contact form");
        assertElementText(By.cssSelector(".sidebar-menu > li[index='3'] span"), "Service");
        assertElementText(By.cssSelector(".sidebar-menu > li[index='4'] span"), "Metals & Colors");
        assertElementText(By.cssSelector(".sidebar-menu > li[index='5'] span"), "Elements packs");
        softAssert.assertAll();
    }
}
