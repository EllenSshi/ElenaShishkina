package hw3.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HeaderMenu {

    @FindBy(xpath = "//nav[@role='navigation']//ul//li")
    private List<WebElement> navigationItems;

    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".nav a[href='index.html']")
    public WebElement homeItem;

    @FindBy(css = ".nav a[href='contacts.html']")
    public WebElement contactFormItem;

    @FindBy(css = ".nav .dropdown")
    public WebElement serviceItem;

    @FindBy(css = ".nav a[href='metals-colors.html']")
    public WebElement metalsAndColorsItem;

    SoftAssert softAssert = new SoftAssert();

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickHeaderMenuItem(String itemName) {
        for (WebElement navigationItem : navigationItems) {
            if (navigationItem.getText().equals(itemName)) {
                navigationItem.click();
                break;
            }
        }
    }

    public void loginAsUser(String username, String password) {
        profilePhoto.click();
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public void assertUserLoggined(String fullname) {
        softAssert.assertEquals(userName.getText(), fullname);
    }
}
