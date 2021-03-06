package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IndexPage extends AbstractPage {

    private final static String path = properties.getIndexPagePath();

    @FindBy(css = ".benefit > .benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit > .benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(css = ".benefits .col-sm-3:nth-child(1) .benefit-txt")
    private WebElement practiceText;

    @FindBy(css = ".benefits .col-sm-3:nth-child(2) .benefit-txt")
    private WebElement customText;

    @FindBy(css = ".benefits .col-sm-3:nth-child(3) .benefit-txt")
    private WebElement multiText;

    @FindBy(css = ".benefits .col-sm-3:nth-child(4) .benefit-txt")
    private WebElement baseText;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    private WebDriver driver;

    private String frameName = "frame";

    public IndexPage(WebDriver driver) {
        super(driver, path);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFrameName() {
        return frameName;
    }

    public Boolean isFrameDisplayed() {
        return frame.isDisplayed();
    }

    public Integer getBenefitImagesCount() {
        return benefitIcons.size();
    }

    public List<String> getBenefitText() {
        List<String> benefitText = new ArrayList<>();
        benefitText.add(practiceText.getText());
        benefitText.add(customText.getText());
        benefitText.add(multiText.getText());
        benefitText.add(baseText.getText());
        return benefitText;
    }

    public String getFrameButtonText() {
        return getAttributeValue(frameButton, "value");
    }
}
