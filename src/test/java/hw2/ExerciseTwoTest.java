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
        open();
        //2. Assert Browser title
        assertTitle();
        //3. Perform login
        loginAsUser();
        //4. Assert User name in the left-top side of screen that user is loggined
        assertUserLoggined();
        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.partialLinkText("SERVICE")).click();
        driver.findElement(By.cssSelector(".dropdown-menu a[href='different-elements.html']")).click();
        //6. Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        List<String> checks = new ArrayList<>();
        checks.add("Water");
        checks.add("Wind");
        clickCheckboxOrRadio(checkboxes, checks);
        //7. Select radio
        List<WebElement> radiobuttons = driver.findElements(By.className("label-radio"));
        List<String> radios = new ArrayList<>();
        radios.add("Selen");
        clickCheckboxOrRadio(radiobuttons, radios);
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
                + radios.get(0) + "')]"));
        driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/*[contains(text(), 'Colors: value changed to "
                + color + "')]"));
        softAssert.assertAll();
    }
}
