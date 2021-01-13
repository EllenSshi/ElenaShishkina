package hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends AbstractPage {

    private final static String path = properties.getUserTablePagePath();

    @FindBy(id = "ivan")
    private WebElement ivanVipCheckbox;

    @FindBy(tagName = "select")
    private List<WebElement> typeDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> usernames;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> vipCheckboxes;

    @FindBy(css = "tbody > tr")
    private List<WebElement> userTRs;

    private WebDriver driver;

    public UserTablePage(WebDriver driver) {
        super(driver, path);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectIvanVipCheckbox() {
        ivanVipCheckbox.click();
    }

    public int getDropdownsNumber() {
        return typeDropdowns.size();
    }

    public int getUsernamesNumber() {
        return usernames.size();
    }

    public int getDescriptionTextsNumber() {
        return descriptionTexts.size();
    }

    public int getVipCheckboxesNumber() {
        return vipCheckboxes.size();
    }

    public List<String> getDroplistValuesFromColumnTypeForUser(String user) {
        List<String> values = new ArrayList<>();
        for (WebElement tr : userTRs) {
            if (tr.findElement(By.cssSelector("td a")).getText().equals(user)) {
                List<WebElement> typeOptions = tr.findElements(By.cssSelector("td select option"));
                for (WebElement option : typeOptions) {
                    values.add(option.getText());
                }
            }
        }
        return values;
    }

    public List<List<String>> getAllUserValues() {
        List<List<String>> values = new ArrayList<>();
        for (WebElement tr : userTRs) {
            List<String> user = new ArrayList<>();
            user.add(tr.findElement(By.cssSelector("td")).getText());
            user.add(tr.findElement(By.cssSelector("td a")).getText());
            user.add(tr.findElement(By.cssSelector("td div span")).getText().replaceAll("\n", " "));
            values.add(user);
        }
        return values;
    }
}
