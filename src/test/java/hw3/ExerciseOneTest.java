package hw3;

import hw3.pages.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ExerciseOneTest extends AbstractTest {

    @Test
    public void testFirstExercise() {
        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.open();
        //2. Assert Browser title
        assertTitle("Home Page");
        //3. Perform login
        indexPage.getHeaderMenu().loginAsUser(properties.getUsername(), properties.getPassword());
        //4. Assert Username is loggined
        indexPage.getHeaderMenu().assertUserLoggined("ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertElementText(indexPage.getHeaderMenu().homeItem, "HOME");
        assertElementText(indexPage.getHeaderMenu().contactFormItem, "CONTACT FORM");
        assertElementText(indexPage.getHeaderMenu().serviceItem, "SERVICE");
        assertElementText(indexPage.getHeaderMenu().metalsAndColorsItem, "METALS & COLORS");
        //6. Assert that there are 4 images on the Index Page and they are displayed
        indexPage.assertFourImages();
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPage.assertFourTexts();
        assertElementText(indexPage.practiceText,
                "To include good practices\nand ideas from successful\nEPAM project");
        assertElementText(indexPage.customText, "To be flexible and\ncustomizable");
        assertElementText(indexPage.multiText, "To be multiplatform");
        assertElementText(indexPage.baseText,
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        //8. Assert that there is the iframe with “Frame Button” exist
        indexPage.verifyIframeExists();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        switchToFrame(indexPage.getFrameName());
        assertAttributeValue(indexPage.frameButton, "value", "Frame Button");
        //10. Switch to original window back
        switchToDefault();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertElementText(indexPage.getLeftSideMenu().homeItem, "Home");
        assertElementText(indexPage.getLeftSideMenu().contactFormItem, "Contact form");
        assertElementText(indexPage.getLeftSideMenu().serviceItem, "Service");
        assertElementText(indexPage.getLeftSideMenu().metalsAndColorsItem, "Metals & Colors");
        assertElementText(indexPage.getLeftSideMenu().elementsPacksItem, "Elements packs");
        softAssert.assertAll();
    }
}
