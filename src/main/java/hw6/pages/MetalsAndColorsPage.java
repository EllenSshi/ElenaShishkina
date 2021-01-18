package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

@Url("/metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @Css("#submit-button") public static Button submitForm;
    public static
}
