package hw4;

import hw3.pages.IndexPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ExerciseOneTest extends AbstractTest {

    @Test(description = "Test exercise 1 from homework 3")
    public void testFirstExercise() {
        //1. Open test site by URL
        actionStep.openIndexPage();
        //2. Assert Browser title
        assertionStep.assertIndexPageTitle("Home Page");
        //3. Perform login
        actionStep.loginAsUserFromIndexPage(properties.getUsername(), properties.getPassword());
        //4. Assert Username is loggined
        assertionStep.assertLogginedUserName(properties.getFullUserName());
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.assertFourHeaderItemsAreDisplayed();
        List<String> expectedHeaderItemsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertionStep.assertFourHeaderItemsText(expectedHeaderItemsText);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertFourImagesAreDisplayed();
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.assertFourTextsUnderIcons();
        List<String> expectedBenefitText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        assertionStep.assertFourIconsText(expectedBenefitText);
        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertFrameExist();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIframe();
        String expectedFrameButtonText = "Frame Button";
        assertionStep.assertFrameButton(expectedFrameButtonText);
        //10. Switch to original window back
        actionStep.switchToDefaultContent();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.assertFiveLeftItemsAreDisplayed();
        List<String> expectedLeftSectionItemsText = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        assertionStep.assertFiveLeftItemsText(expectedLeftSectionItemsText);
        assertionStep.assertAll();
    }
}
