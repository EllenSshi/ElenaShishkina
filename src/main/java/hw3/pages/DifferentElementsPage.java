package hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private final static String path = "different-elements.html";

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radiobuttons;

    @FindBy(className = "colors")
    private WebElement colorDropdown;

    private WebDriver driver;

    public DifferentElementsPage(WebDriver driver) {
        super(driver, path);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCheckboxes(List<String> names) {
        selectCheckboxOrRadio(checkboxes,  names);
    }

    public void selectRadio(List<String> names) {
        selectCheckboxOrRadio(radiobuttons,  names);
    }

    public void selectColorInDropdown(String color) {
        colorDropdown.findElement(By.xpath("//option[contains(text(), '" + color + "')]")).click();
    }
}
