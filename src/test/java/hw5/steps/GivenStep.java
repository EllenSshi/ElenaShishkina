package hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void iOpenJDIGitHubSite() {
        indexPage.open();
    }

    @Given("I login as user {string} {string}")
    public void iLoginAsUser(String username, String password) {
        indexPage.loginAsUser(username, password);
    }

    @Given("I click on \"Service\" button in Header")
    public void iClickOnServiceButtonInHeader() {
        indexPage.clickOnService();
    }

    @Given("I click on \"User Table\" button in Service dropdown")
    public void iClickOnUserTableButtonInServiceDropdown() {
        indexPage.goToUserTablePage();
    }

    @Given("Browser title equals {string}")
    public void browserTitleEquals(String title) {
        softAssert.assertEquals(indexPage.getPageTitle(), title, "Not expected Index page Title");
    }

    @Given("User name in the left-top side of screen is displayed and equals to {string}")
    public void userNameIsDisplayedAndEqualsTo(String username) {
        softAssert.assertEquals(indexPage.getLogginedUserName(), username);
    }

    @Given("I open through the header menu Service -> Different Elements Page")
    public void iOpenDifElementsPage() {
        indexPage.goToDifferentElementsPage();
    }
}
