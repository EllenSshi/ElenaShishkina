package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LeftSideMenu {

    @FindBy(css = ".sidebar-menu li")
    private List<WebElement> leftSideMenuItems;

    @FindBy(css = ".sidebar-menu > li[index='1'] span")
    public WebElement homeItem;

    @FindBy(css = ".sidebar-menu > li[index='2'] span")
    public WebElement contactFormItem;

    @FindBy(css = ".sidebar-menu > li[index='3'] span")
    public WebElement serviceItem;

    @FindBy(css = ".sidebar-menu > li[index='4'] span")
    public WebElement metalsAndColorsItem;

    @FindBy(css = ".sidebar-menu > li[index='5'] span")
    public WebElement elementsPacksItem;

    public LeftSideMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getLeftSectionItemsText() {
        List<String> leftSecItemsText = new ArrayList<>();
        leftSecItemsText.add(homeItem.getText());
        leftSecItemsText.add(contactFormItem.getText());
        leftSecItemsText.add(serviceItem.getText());
        leftSecItemsText.add(metalsAndColorsItem.getText());
        leftSecItemsText.add(elementsPacksItem.getText());
        return leftSecItemsText;
    }
}
