package hw8;

import com.google.gson.Gson;
import hw8.dto.SpellRequestDto;
import hw8.dto.SpellResultDto;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class SpellTestData {

    @DataProvider(name="spellerTestData")
    public static Object[][] testDataProvider() throws IOException, ParseException {
        Object obj = readJson("src/test/resources/hw8/spellerTestData.json");
        SpellRequestDto[] req = new Gson().fromJson(obj.toString(), SpellRequestDto[].class);
        SpellResultDto[] res = new Gson().fromJson(obj.toString(), SpellResultDto[].class);
        Object[][] allData = new Object[req.length][2];
        for (int i = 0; i < req.length; i++) {
            Object[] reqAndRes = new Object[]{req[i], res[i]};
            allData[i] = reqAndRes;
        }
        return allData;
    }

    public static Object readJson(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);
        return jsonParser.parse(fileReader);
    }
}
