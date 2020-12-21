package hw3;

import hw3.pages.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTwoTest extends AbstractTest {

    @Test
    public void testSecondExercise() {
        //1. Open test site by URL
        open("index.html");
        //2. Assert Browser title
        assertTitle("Home Page");
        //3. Perform login
        IndexPage indexPage = new IndexPage(driver);
        indexPage.getHeaderMenu().loginAsUser(properties.getUsername(), properties.getPassword());
        //4. Assert User name in the left-top side of screen that user is loggined
        indexPage.getHeaderMenu().assertUserLoggined("ROMAN IOVLEV");
        //5. Open through the header menu Service -> Different Elements Page
        clickOnElement(By.partialLinkText("SERVICE"));
        clickOnElement(By.cssSelector(".dropdown-menu a[href='different-elements.html']"));
        //6. Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        List<String> checks = new ArrayList<>();
        checks.add("Water");
        checks.add("Wind");
        selectCheckboxOrRadio(checkboxes, checks);
        //7. Select radio
        List<WebElement> radiobuttons = driver.findElements(By.className("label-radio"));
        List<String> radios = new ArrayList<>();
        radios.add("Selen");
        selectCheckboxOrRadio(radiobuttons, radios);
        //8. Select in dropdown
        String color = "Yellow";
        clickOnElement(By.className("colors"));
        clickOnElement(By.xpath("//option[contains(text(), '" + color + "')]"));
        //9. Assert that
        //	•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //	•	for radio button there is a log row and value is corresponded to the status of radio button
        //	•	for dropdown there is a log row and value is corresponded to the selected value.
        findTextInLog(checks.get(0) + ": condition changed to true");
        findTextInLog(checks.get(1) + ": condition changed to true");
        findTextInLog("metal: value changed to  " + radios.get(0));
        findTextInLog("Colors: value changed to " + color);
        softAssert.assertAll();
    }
}
