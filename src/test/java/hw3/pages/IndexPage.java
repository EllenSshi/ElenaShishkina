package hw3.pages;

import com.google.inject.Inject;
import hw3.pagecomponents.HeaderMenu;
import hw3.pagecomponents.LeftSideMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IndexPage extends AbstractPage {

    private final static String path = "index.html";

    @FindBy(xpath = "//nav[@role='navigation']//ul//li")
    private List<WebElement> navigationItems;

    @FindBy(css = ".benefit > .benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit > .benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(css = ".benefits .col-sm-3:nth-child(1) .benefit-txt")
    public WebElement practiceText;

    @FindBy(css = ".benefits .col-sm-3:nth-child(2) .benefit-txt")
    public WebElement customText;

    @FindBy(css = ".benefits .col-sm-3:nth-child(3) .benefit-txt")
    public WebElement multiText;

    @FindBy(css = ".benefits .col-sm-3:nth-child(4) .benefit-txt")
    public WebElement baseText;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    SoftAssert softAssert = new SoftAssert();
    private WebDriver driver;
    private HeaderMenu headerMenu;
    private LeftSideMenu leftSideMenu;

    private String frameName = "frame";

    @Inject
    public IndexPage(WebDriver driver) {
        super(driver, path);
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        leftSideMenu = new LeftSideMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public void assertFourImages() {
        softAssert.assertEquals(benefitIcons.size(), 4);
    }

    public void assertFourTexts() {
        softAssert.assertEquals(benefitTexts.size(), 4);
    }

    public String getFrameName() {
        return frameName;
    }

    public void verifyIframeExists() {
        frame.isDisplayed();
    }
}
