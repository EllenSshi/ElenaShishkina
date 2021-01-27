package hw6.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @Css("#submit-button") public static Button submitButton;
    @UI("[name=custom_radio_odd]") public static RadioButtons odds;
    @UI("[name=custom_radio_even]") public static RadioButtons evens;
    @UI("#elements-checklist [type=checkbox]") public static Checklist elems;
    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown clrs;
    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;
    @JDropdown(root = "div[ui=droplist]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;

    @Override
    public void submit(MetalsAndColors metalsAndColors) {
        String odd = metalsAndColors.summary[0].toString();
        odds.select(odd);
        String even = metalsAndColors.summary[1].toString();
        evens.select(even);
        for (int i = 0; i < metalsAndColors.elements.length; i++) {
            elems.select(metalsAndColors.elements[i]);
        }
        String color = metalsAndColors.color;
        clrs.select(color);
        String metal = metalsAndColors.metals;
        metals.select(metal);
        vegetables.select("Vegetables");
        for (int i = 0; i < metalsAndColors.vegetables.length; i++) {
            vegetables.select(metalsAndColors.vegetables[i]);
        }
        submitButton.click();
    }
}
