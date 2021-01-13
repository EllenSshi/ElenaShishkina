package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.List;

public class ThenStep extends AbstractStep {

    @Then("1 log row has {string} text in log section")
    public void oneLogRowHasTextInLogSection(String expectedLogRecord) {
        List<String> expectedLogRecords = Arrays.asList(expectedLogRecord);
        softAssert.assertTrue(userTablePage.areLogRecordsAsExpected(expectedLogRecords));
    }

    @Then("There are log records:")
    public void thereAreLogRecords(DataTable records) {
        List<String> expectedLogRecords = records.asList(String.class);
        softAssert.assertTrue(difElementsPage.areLogRecordsAsExpected(expectedLogRecords));
        softAssert.assertAll();
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String title) {
        softAssert.assertEquals(userTablePage.getPageTitle(), title, "Not expected Index page Title");
    }

    @Then("{word} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void typeDropdownsShouldBeDisplayed(String number) {
        softAssert.assertEquals(userTablePage.getDropdownsNumber(), Integer.parseInt(number));
    }

    @Then("{word} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayed(String number) {
        softAssert.assertEquals(userTablePage.getUsernamesNumber(), Integer.parseInt(number));
    }

    @Then("{word} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsShouldBeDisplayed(String number) {
        softAssert.assertEquals(userTablePage.getDescriptionTextsNumber(), Integer.parseInt(number));
    }

    @Then("{word} checkboxes should be displayed on Users Table on User Table Page")
    public void vipCheckboxesShouldBeDisplayed(String number) {
        softAssert.assertEquals(userTablePage.getVipCheckboxesNumber(), Integer.parseInt(number));
    }

    @Then("User table should contain following values:")
    public void userTableShouldContain(DataTable values) {
        List<List<String>> expectedValues = values.subTable(1,0).asLists();
        List<List<String>> actualValues = userTablePage.getAllUserValues();
        softAssert.assertEquals(actualValues, expectedValues);
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistShouldContainValuesInColumnTypeForUser(String user, DataTable values) {
        List<String> actualValues = userTablePage.getDroplistValuesFromColumnTypeForUser(user);
        List<String> expectedValues = values.subTable(1,0).asList();
        softAssert.assertEquals(actualValues, expectedValues);
        softAssert.assertAll();
    }
}
