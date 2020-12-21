package hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AbstractPage {

    private WebDriver driver;
    private final String baseUrl = "https://jdi-testing.github.io/jdi-light/";
    private String url;

    SoftAssert softAssert = new SoftAssert();

    public AbstractPage(WebDriver driver, String path) {
        this.driver = driver;
        this.url = baseUrl + path;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(url);
    }

    public void assertElementText(WebElement element, String text) {
        softAssert.assertEquals(element.getText(),
                text);
    }
}
