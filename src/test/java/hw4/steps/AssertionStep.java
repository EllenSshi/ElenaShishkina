package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert that Index Page Title is '{title}'")
    public void assertIndexPageTitle(String title) {
        softAssert.assertEquals(indexPage.getPageTitle(), title, "Not expected Index page Title");
    }

    @Step("Assert that loggined user name is '{fullname}'")
    public void assertLogginedUserName(String fullname) {
        softAssert.assertEquals(indexPage.getLogginedUserName(), fullname);
    }

    @Step("Assert that there are 4 items on the header section")
    public void assertFourHeaderItemsAreDisplayed() {
        int actualHeaderItems = indexPage.getNavigationItemsText().size();
        int expectedHeaderItems = 4;
        softAssert.assertEquals(actualHeaderItems, expectedHeaderItems,
                String.format("Expected %s navigation items on Index Page, but got %s ", expectedHeaderItems,
                        actualHeaderItems));
    }

    @Step("Assert that four header items have proper text")
    public void assertFourHeaderItemsText(List<String> expectedHeaderItemsText) {
        List<String> actualHeaderItemsText = indexPage.getNavigationItemsText();
        softAssert.assertEquals(actualHeaderItemsText, expectedHeaderItemsText);
    }

    @Step("Assert that there are 4 images on the Index Page")
    public void assertFourImagesAreDisplayed() {
        int actualImagesCount = indexPage.getBenefitImagesCount();
        int expectedImagesCount = 4;
        softAssert.assertEquals(actualImagesCount, expectedImagesCount,
                String.format("Expected %s Images, but got %s", expectedImagesCount, actualImagesCount));
    }

    @Step("Assert that there are 4 texts on the Index Page under icons")
    public void assertFourTextsUnderIcons() {
        int actualTextCount = indexPage.getBenefitText().size();
        int expectedTextCount = 4;
        softAssert.assertEquals(actualTextCount, expectedTextCount,
                String.format("Expected %s Images, but got %s", expectedTextCount, actualTextCount));
    }

    @Step("Assert that 4 texts on the Index Page under icons are proper")
    public void assertFourIconsText(List<String> expectedBenefitText) {
        List<String> actualBenefitText = indexPage.getBenefitText();
        softAssert.assertEquals(actualBenefitText, expectedBenefitText);
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void assertFrameExist() {
        softAssert.assertTrue(indexPage.isFrameDisplayed());
    }

    @Step("Assert that there is “Frame Button” in the iframe")
    public void assertFrameButton(String expectedFrameButtonText) {
        String actualFrameButtonText = indexPage.getFrameButtonText();
        softAssert.assertEquals(actualFrameButtonText, expectedFrameButtonText,
                String.format("Expected %s Frame button text, but got %s", expectedFrameButtonText, actualFrameButtonText));
    }

    @Step("Assert that there are 5 items in the Left Section")
    public void assertFiveLeftItemsAreDisplayed() {
        int actualLeftSectionItems = indexPage.getLeftSectionItemsText().size();
        int expectedLeftSectionItems = 5;
        softAssert.assertEquals(actualLeftSectionItems, expectedLeftSectionItems,
                String.format("Expected %s Left Section items on Index Page, but got %s ",
                        expectedLeftSectionItems, actualLeftSectionItems));
    }

    @Step("Assert that five items in the Left Section have proper text")
    public void assertFiveLeftItemsText(List<String> expectedLeftSectionItemsText) {
        List<String> actualLeftSectionItemsText = indexPage.getLeftSectionItemsText();
        softAssert.assertEquals(actualLeftSectionItemsText, expectedLeftSectionItemsText);
    }

    @Step("Assert that Logs are as expected")
    public void assertLogs(List<String> expectedLogRecords) {
        softAssert.assertTrue(difElementsPage.areLogRecordsAsExpected(expectedLogRecords));
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
