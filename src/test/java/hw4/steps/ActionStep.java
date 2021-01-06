package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Switch to the iframe with Frame Button")
    public void switchToIframe() {
        indexPage.switchToFrame(indexPage.getFrameName());
    }

    @Step("Switch to original window back")
    public void switchToDefaultContent() {
        indexPage.switchToDefault();
    }

    @Step("Select checkboxes '{checks}'")
    public void selectCheckboxes(List<String> checks) {
        difElementsPage.selectCheckboxes(checks);
    }

    @Step("Select radiobuttons '{radios}'")
    public void selectRadio(List<String> radios) {
        difElementsPage.selectRadio(radios);
    }

    @Step("Select color '{color}' in Dropdown")
    public void selectColor(String color) {
        difElementsPage.selectColorInDropdown(color);
    }
}
