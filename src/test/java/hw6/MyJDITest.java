package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static hw6.JDITestSite.metalsAndColorsPage;
import static hw6.TestData.DEFAULT_USER;
import static hw6.JDITestSite.indexPage;
import static hw6.pages.IndexPage.*;
import static hw6.pages.MetalsAndColorsPage.*;

public class MyJDITest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JDITestSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "dp")
    public void metalsAndColorsTest(JSONObject metalColor) {
        indexPage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        indexPage.checkOpened();
        metalsAndColors.click();
        metalsAndColorsPage.checkOpened();
        odds.select(((JSONArray) metalColor.get("summary")).get(0).toString());
        evens.select(((JSONArray) metalColor.get("summary")).get(1).toString());
        JSONArray elements = (JSONArray) metalColor.get("elements");
        for (int i = 0; i < elements.size(); i++) {
            elems.select(elements.get(i).toString());
        }
        clrs.select(metalColor.get("color").toString());
        metals.select(metalColor.get("metals").toString());
        JSONArray vegs = (JSONArray) metalColor.get("vegetables");
        vegetables.select("Vegetables");
        for (int i = 0; i < vegs.size(); i++) {
            vegetables.select(vegs.get(i).toString());
        }
        submitForm.click();

        userIcon.click();
        logout.click();
    }

    @DataProvider(name="dp")
    public Object[] readJson() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json");
        Object obj = jsonParser.parse(fileReader);

        JSONObject data = (JSONObject) obj;
        JSONObject metalsColors[] = new JSONObject[data.size()];
        for (int i = 1; i <= data.size(); i++) {
            metalsColors[i-1] = (JSONObject) data.get("data_" + i);
        }
        return metalsColors;
    }
}
