package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTwoTest extends AbstractTest {
    @Test
    public void testSecondExercise() {
        //1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        //3. Perform login
        driver.findElement(By.className("profile-photo")).click();
        driver.findElements(By.id("name")).get(0).sendKeys("Roman");
        driver.findElements(By.id("password")).get(0).sendKeys("Jdi1234");
        driver.findElements(By.id("login-button")).get(0).click();
        //4. Assert User name in the left-top side of screen that user is loggined
        softAssert.assertEquals(driver.findElements(By.id("user-name")).get(0).getText(), "ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.partialLinkText("SERVICE")).click();
        driver.findElements(By.cssSelector("a[href='different-elements.html']")).get(0).click();
        //6. Select checkboxes
        List<String> checks = new ArrayList<>();
        checks.add("Water");
        checks.add("Wind");
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        for (WebElement element : checkboxes) {
            if (element.getText().equals(checks.get(0)) || element.getText().equals(checks.get(1))) {
                element.click();
            }
        }
        //7. Select radio
        String radio = "Selen";
        List<WebElement> radiobuttons = driver.findElements(By.className("label-radio"));
        for (WebElement element : radiobuttons) {
            if (element.getText().equals(radio)) {
                element.click();
            }
        }
        //8. Select in dropdown
        String color = "Yellow";
        driver.findElement(By.className("colors")).click();
        driver.findElement(By.xpath("//option[contains(text(), '" + color + "')]")).click();
        //9. Assert that
        //	•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //	•	for radio button there is a log row and value is corresponded to the status of radio button
        //	•	for dropdown there is a log row and value is corresponded to the selected value.
        driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/*[contains(text(), '"
                + checks.get(0) + ": condition changed to true')]"));
        driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/*[contains(text(), '"
                + checks.get(1) + ": condition changed to true')]"));
        driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/*[contains(text(), 'metal: value changed to  "
                + radio + "')]"));
        driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/*[contains(text(), 'Colors: value changed to "
                + color + "')]"));
        softAssert.assertAll();
    }
}
