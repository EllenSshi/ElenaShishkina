package hw3.pages;

import hw3.MyProperties;
import hw3.pages.components.HeaderMenu;
import hw3.pages.components.LeftSideMenu;
import hw3.pages.components.LogSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractPage {

    static MyProperties properties = new MyProperties();
    private WebDriver driver;
    private final String baseUrl = properties.getBaseUrl();
    private String url;
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;
    private LogSection logSection;

    public AbstractPage(WebDriver driver, String path) {
        this.driver = driver;
        this.url = baseUrl + path;
        headerMenu = new HeaderMenu(driver);
        leftSideMenu = new LeftSideMenu(driver);
        logSection = new LogSection(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(url);
    }

    public void loginAsUser(String username, String password) {
        headerMenu.loginAsUser(username, password);
    }

    public String getLogginedUserName() {
        return headerMenu.getLogginedUserName();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getNavigationItemsText() {
        return headerMenu.getNavigationItemsText();
    }

    public List<String> getLeftSectionItemsText() {
        return leftSideMenu.getLeftSectionItemsText();
    }

    public String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public void goToDifferentElementsPage() {
        headerMenu.goToDifferentElementsPage();
    }

    public void clickOnService() {
        headerMenu.clickOnService();
    }

    public void goToUserTablePage() {
        headerMenu.goToUserTablePage();
    }

    public void selectCheckboxOrRadio(List<WebElement> elements, List<String> names) {
        for (WebElement element : elements) {
            for (String name : names) {
                if (element.getText().equals(name)) {
                    element.click();
                }
            }
        }
    }

    public Boolean areLogRecordsAsExpected(List<String> logs) {
        return logSection.areLogRecordsAsExpected(logs);
    }

    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
