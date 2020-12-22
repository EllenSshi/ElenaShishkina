package hw3.pages.components;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LogSection {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logRecords;

    public LogSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean areLogRecordsAsExpected(List<String> logs) {
        if (logRecords.size() == logs.size()) {
            for (int i = 0; i < logRecords.size(); i++) {
                if (!logRecords.get(i).getText().contains(logs.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
