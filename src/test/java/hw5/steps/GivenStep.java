package hw5.steps;

import io.cucumber.java.en.Given;

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
}
