package hw5.steps;

import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.List;

public class ThenStep extends AbstractStep {

    @Then("1 log row has {string} text in log section")
    public void oneLogRowHasTextInLogSection(String expectedLogRecord) {
        List<String> expectedLogRecords = Arrays.asList(expectedLogRecord);
        softAssert.assertTrue(userTablePage.areLogRecordsAsExpected(expectedLogRecords));
    }
}
