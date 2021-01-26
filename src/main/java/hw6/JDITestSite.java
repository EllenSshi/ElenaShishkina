package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import hw6.entities.User;
import hw6.pages.IndexPage;
import hw6.pages.MetalsAndColorsPage;
import hw6.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDITestSite {

    @Url("/index.html") @Title("Home Page")
    public static IndexPage indexPage;
    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Css("form") public static LoginForm loginForm;
    @Css("img#user-icon") public static Icon userIcon;
    @Css(".logout button") public static Button logout;
    @Css(".nav a[href='metals-colors.html']") public static Link metalsAndColors;

    public static void open() {
        indexPage.open();
    }

    public static void openPageFromMenu(Link link) {
        link.click();
    }

    public static void login(User user) {
        userIcon.click();
        loginForm.loginAs(user);
        indexPage.checkOpened();
    }

    public static void logout() {
        userIcon.click();
        logout.click();
    }
}
