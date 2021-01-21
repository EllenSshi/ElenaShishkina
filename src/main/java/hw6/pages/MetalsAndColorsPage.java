package hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

@Url("/metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @Css("#submit-button") public static Button submitForm;
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
    @Css(".summ-res")
    public static UIElement sumRes;
    @Css(".elem-res")
    public static UIElement elemRes;
    @Css(".col-res")
    public static UIElement colorRes;
    @Css(".met-res")
    public static UIElement metRes;
    @Css(".sal-res")
    public static UIElement vegRes;
}
