package hw6;

import hw6.entities.MetalsAndColors;
import hw6.entities.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;


public class JDITestData {

    public static User DEFAULT_USER = new User().set(
            u -> {u.userName = "Roman"; u.password = "Jdi1234";});

    @DataProvider(name="metalsAndColors")
    public static Object[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json");
        Object obj = jsonParser.parse(fileReader);

        JSONObject data = (JSONObject) obj;
        MetalsAndColors[] metalsAndColors = new MetalsAndColors[data.size()];
        for (int i = 1; i <= data.size(); i++) {
            JSONObject metalAndColor = (JSONObject) data.get("data_" + i);
            Integer[] summary = new Integer[2];
            summary[0] = Integer.parseInt(((JSONArray) metalAndColor.get("summary")).get(0).toString());
            summary[1] = Integer.parseInt(((JSONArray) metalAndColor.get("summary")).get(1).toString());
            JSONArray elems = (JSONArray) metalAndColor.get("elements");
            String[] elements = new String[elems.size()];
            for (int j = 0; j < elems.size(); j++) {
                elements[j] = elems.get(j).toString();
            }
            String color = metalAndColor.get("color").toString();
            String metal = metalAndColor.get("metals").toString();

            JSONArray vegs = (JSONArray) metalAndColor.get("vegetables");
            String[] vegetables = new String[vegs.size()];
            for (int k = 0; k < vegs.size(); k++) {
                vegetables[k] = vegs.get(k).toString();
            }
            metalsAndColors[i-1] = new MetalsAndColors().set(
                    mc -> {mc.summary = summary; mc.elements = elements; mc.color = color; mc.metals = metal;
                    mc.vegetables = vegetables;}
            );
        }
        return metalsAndColors;
    }
}
