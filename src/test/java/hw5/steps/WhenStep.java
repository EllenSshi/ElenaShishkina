package hw5.steps;

import io.cucumber.java.en.When;

public class WhenStep extends AbstractStep {

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void iSelectVipCheckboxForIvan() {
        userTablePage.selectIvanVipCheckbox();
    }
}
