package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw6.pages.IndexPage;
import hw6.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDITestSite {

    @Url("/index.html") @Title("Home Page")
    public static IndexPage indexPage;
    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        indexPage.open();
    }
}
