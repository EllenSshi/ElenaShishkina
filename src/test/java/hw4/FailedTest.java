package hw4;

import hw3.pages.IndexPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FailedTest extends AbstractTest {

    @Test
    public void testFirstExercise() {
        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.open();
        //2. Assert Browser title
        softAssert.assertEquals(indexPage.getPageTitle(), "Home Page", "Not expected Index page Title");
        //3. Perform login
        indexPage.loginAsUser(properties.getUsername(), properties.getPassword());
        //4. Assert Username is loggined
        softAssert.assertEquals(indexPage.getLogginedUserName(), properties.getFullUserName());
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        int actualHeaderItems = indexPage.getNavigationItemsText().size();
        int expectedHeaderItems = 3;
        softAssert.assertEquals(actualHeaderItems, expectedHeaderItems,
                String.format("Expected %s navigation items on Index Page, but got %s ", expectedHeaderItems,
                        actualHeaderItems));
        List<String> actualHeaderItemsText = indexPage.getNavigationItemsText();
        List<String> expectedHeaderItemsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(actualHeaderItemsText, expectedHeaderItemsText);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        int actualImagesCount = indexPage.getBenefitImagesCount();
        int expectedImagesCount = 4;
        softAssert.assertEquals(actualImagesCount, expectedImagesCount,
                String.format("Expected %s Images, but got %s", expectedImagesCount, actualImagesCount));
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        int actualTextCount = indexPage.getBenefitText().size();
        int expectedTextCount = 4;
        softAssert.assertEquals(actualTextCount, expectedTextCount,
                String.format("Expected %s Images, but got %s", expectedTextCount, actualTextCount));
        List<String> actualBenefitText = indexPage.getBenefitText();
        List<String> expectedBenefitText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        softAssert.assertEquals(actualBenefitText, expectedBenefitText);
        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(indexPage.isFrameDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        switchToFrame(indexPage.getFrameName());
        String actualFrameButtonText = indexPage.getFrameButtonText();
        String expectedFrameButtonText = "Frame Button";
        softAssert.assertEquals(actualFrameButtonText, expectedFrameButtonText,
                String.format("Expected %s Frame button text, but got %s", expectedFrameButtonText, actualFrameButtonText));
        //10. Switch to original window back
        switchToDefault();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        int actualLeftSectionItems = indexPage.getLeftSectionItemsText().size();
        int expectedLeftSectionItems = 5;
        softAssert.assertEquals(actualLeftSectionItems, expectedLeftSectionItems,
                String.format("Expected %s Left Section items on Index Page, but got %s ",
                        expectedLeftSectionItems, actualLeftSectionItems));
        List<String> actualLeftSectionItemsText = indexPage.getLeftSectionItemsText();
        List<String> expectedLeftSectionItemsText = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(actualLeftSectionItemsText, expectedLeftSectionItemsText);
        softAssert.assertAll();
    }
}
