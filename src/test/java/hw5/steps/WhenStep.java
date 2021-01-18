package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class WhenStep extends AbstractStep {

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void iSelectVipCheckboxForIvan() {
        userTablePage.selectIvanVipCheckbox();
    }

    @When("I select checkboxes")
    public void iSelectCheckboxes(DataTable checkboxes) {
        List<String> checks = checkboxes.asList(String.class);
        difElementsPage.selectCheckboxes(checks);
    }

    @When("I select radiobutton {string}")
    public void iSelectRadiobutton(String radio) {
        List<String> radios = new ArrayList<>();
        radios.add(radio);
        difElementsPage.selectRadio(radios);
    }

    @When("I select dropdown color {string}")
    public void iSelectDropdownColor(String color) {
        difElementsPage.selectColorInDropdown(color);
    }
}
