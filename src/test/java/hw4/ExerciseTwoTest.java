package hw4;

import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Feature("Homework 4. Allure + Jenkins")
@Story("Exercise two")
public class ExerciseTwoTest extends AbstractTest {

    @Test(description = "Test exercise 2 from homework 3")
    public void testSecondExercise() {
        //1. Open test site by URL
        actionStep.openIndexPage();
        //2. Assert Browser title
        assertionStep.assertIndexPageTitle("Home Page");
        //3. Perform login
        actionStep.loginAsUserFromIndexPage(properties.getUsername(), properties.getPassword());
        //4. Assert User name in the left-top side of screen that user is loggined
        assertionStep.assertLogginedUserName(properties.getFullUserName());
        //5. Open through the header menu Service -> Different Elements Page
        actionStep.goToDifferentElementsPage();
        //6. Select checkboxes
        List<String> checks = new ArrayList<>();
        checks.add("Water");
        checks.add("Wind");
        actionStep.selectCheckboxes(checks);
        //7. Select radio
        List<String> radios = new ArrayList<>();
        radios.add("Selen");
        actionStep.selectRadio(radios);
        //8. Select in dropdown
        String color = "Yellow";
        actionStep.selectColor(color);
        //9. Assert that
        //	•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //	•	for radio button there is a log row and value is corresponded to the status of radio button
        //	•	for dropdown there is a log row and value is corresponded to the selected value.
        List<String> expectedLogRecords = Arrays.asList(
                "Colors: value changed to " + color,
                "metal: value changed to " + radios.get(0),
                checks.get(1) + ": condition changed to true",
                checks.get(0) + ": condition changed to true");
        assertionStep.assertLogs(expectedLogRecords);
        assertionStep.assertAll();
    }
}
