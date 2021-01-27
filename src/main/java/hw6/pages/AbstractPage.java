package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import hw6.entities.User;
import hw6.sections.LoginForm;

public abstract class AbstractPage extends WebPage {

    @Css("form") public LoginForm loginForm;
    @Css("img#user-icon") public Icon userIcon;
    @Css(".logout button") public Button logout;
    @Css(".nav a[href='metals-colors.html']") public Link metalsAndColors;

    public void openPageFromMenu(Link link) {
        link.click();
    }

    public void login(User user) {
        userIcon.click();
        loginForm.loginAs(user);
    }

    public void logout() {
        userIcon.click();
        logout.click();
    }
}
