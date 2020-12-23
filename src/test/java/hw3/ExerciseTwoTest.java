package hw3;

import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseTwoTest extends AbstractTest {

    @Test
    public void testSecondExercise() {
        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.open();
        //2. Assert Browser title
        softAssert.assertEquals(indexPage.getPageTitle(), "Home Page", "Not expected Index page Title");
        //3. Perform login
        indexPage.loginAsUser(properties.getUsername(), properties.getPassword());
        //4. Assert User name in the left-top side of screen that user is loggined
        softAssert.assertEquals(indexPage.getLogginedUserName(), properties.getFullUserName());
        //5. Open through the header menu Service -> Different Elements Page
        indexPage.goToDifferentElementsPage();
        DifferentElementsPage difElementsPage = new DifferentElementsPage(driver);
        //6. Select checkboxes
        List<String> checks = new ArrayList<>();
        checks.add("Water");
        checks.add("Wind");
        difElementsPage.selectCheckboxes(checks);
        //7. Select radio
        List<String> radios = new ArrayList<>();
        radios.add("Selen");
        difElementsPage.selectRadio(radios);
        //8. Select in dropdown
        String color = "Yellow";
        difElementsPage.selectColorInDropdown(color);
        //9. Assert that
        //	•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //	•	for radio button there is a log row and value is corresponded to the status of radio button
        //	•	for dropdown there is a log row and value is corresponded to the selected value.
        List<String> expectedLogRecords = Arrays.asList(
                "Colors: value changed to " + color,
                "metal: value changed to " + radios.get(0),
                checks.get(1) + ": condition changed to true",
                checks.get(0) + ": condition changed to true");
        softAssert.assertTrue(difElementsPage.areLogRecordsAsExpected(expectedLogRecords));
        softAssert.assertAll();
    }
}
