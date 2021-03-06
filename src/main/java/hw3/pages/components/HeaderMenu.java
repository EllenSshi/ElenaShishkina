package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu {

    @FindBy(css = "nav[role='navigation'] > ul:nth-child(3) > li")
    private List<WebElement> navigationItems;

    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement logginedUserName;

    @FindBy(css = ".nav a[href='index.html']")
    private WebElement homeItem;

    @FindBy(css = ".nav a[href='contacts.html']")
    private WebElement contactFormItem;

    @FindBy(css = ".nav .dropdown")
    private WebElement serviceItem;

    @FindBy(css = ".nav a[href='metals-colors.html']")
    private WebElement metalsAndColorsItem;

    @FindBy(css = ".dropdown-menu a[href='different-elements.html']")
    private WebElement differentElementsItem;

    @FindBy(css = ".dropdown-menu a[href='user-table.html']")
    private WebElement userTableItem;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginAsUser(String username, String password) {
        profilePhoto.click();
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public String getLogginedUserName() {
        return logginedUserName.getText();
    }

    public List<String> getNavigationItemsText() {
        List<String> navItemsText = new ArrayList<>();
        navItemsText.add(homeItem.getText());
        navItemsText.add(contactFormItem.getText());
        navItemsText.add(serviceItem.getText());
        navItemsText.add(metalsAndColorsItem.getText());
        return navItemsText;
    }

    public void clickOnService() {
        serviceItem.click();
    }

    public void goToUserTablePage() {
        userTableItem.click();
    }

    public void goToDifferentElementsPage() {
        serviceItem.click();
        differentElementsItem.click();
    }
}
