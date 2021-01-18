package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import hw6.sections.LoginForm;

@Url("/index.html") @Title("Home Page")
public class IndexPage extends WebPage {

    @Css("form") public static LoginForm loginForm;
    @Css("img#user-icon") public static Icon userIcon;
    @Css(".nav a[href='metals-colors.html']") public static Link metalsAndColors;
}
