package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import hw6.pages.IndexPage;
import hw6.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDITestSite {

    public static IndexPage indexPage;
    public static MetalsAndColorsPage metalsAndColorsPage;
}
