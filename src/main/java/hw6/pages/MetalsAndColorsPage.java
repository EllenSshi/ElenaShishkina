package hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6.entities.MetalsAndColors;
import hw6.sections.MetalsAndColorsForm;
import org.testng.asserts.SoftAssert;

public class MetalsAndColorsPage extends AbstractPage {

    @Css(".form") public MetalsAndColorsForm metalsAndColorsForm;
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

    public void checkResult(MetalsAndColors metalsAndColors) {
        SoftAssert softAssert = new SoftAssert();

        String odd = metalsAndColors.summary[0].toString();
        String even = metalsAndColors.summary[1].toString();
        String expectedSumRes = String.valueOf(Integer.parseInt(odd) + Integer.parseInt(even));
        String actualSumRes = sumRes.getText().split(" ")[1];
        softAssert.assertEquals(actualSumRes, expectedSumRes);

        String[] elements = metalsAndColors.elements;
        String actualElems = elemRes.getText().split(": ")[1];
        softAssert.assertEquals(actualElems.split(", "), elements);

        String expectedColor = metalsAndColors.color;
        softAssert.assertEquals(expectedColor, colorRes.getText().split(": ")[1]);

        String expectedMetal = metalsAndColors.metals;
        softAssert.assertEquals(expectedMetal, metRes.getText().split(": ")[1]);

        String[] vegs = metalsAndColors.vegetables;
        String actualVegs = vegRes.getText().split(": ")[1];
        softAssert.assertEquals(actualVegs.split(", "), vegs);
        softAssert.assertAll();
    }
}
