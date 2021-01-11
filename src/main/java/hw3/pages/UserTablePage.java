package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage extends AbstractPage {

    private final static String path = properties.getUserTablePagePath();

    @FindBy(id = "ivan")
    private WebElement ivanVipCheckbox;

    private WebDriver driver;

    public UserTablePage(WebDriver driver) {
        super(driver, path);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectIvanVipCheckbox() {
        ivanVipCheckbox.click();
    }
}
