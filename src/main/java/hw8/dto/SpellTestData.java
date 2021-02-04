package hw8.dto;

import hw6.entities.MetalsAndColors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SpellTestData {
    @DataProvider(name="spellerTestData")
    public static Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/resources/hw8/spellerTestData.json");
        Object obj = jsonParser.parse(fileReader);

        JSONArray data = (JSONArray) obj;
        SpellRequestDto[] requests = new SpellRequestDto[data.size()];
        SpellResultDto[] results = new SpellResultDto[data.size()];
        Object[][] allData = new Object[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            JSONObject oneData = (JSONObject) data.get(i);
            String text = oneData.get("text").toString();
            String lang = oneData.get("lang").toString();
            int expCode = Integer.parseInt(oneData.get("expectedCode").toString());
            JSONArray expWordsArray = (JSONArray) oneData.get("expectedWords");
            String[] expWords = new String[expWordsArray.size()];
            for (int j=0; j<expWordsArray.size(); j++) {
                expWords[j] = expWordsArray.get(j).toString();
            }
            SpellRequestDto request = new SpellRequestDto();
            request.setText(text);
            request.setLang(lang);
            SpellResultDto result = new SpellResultDto();
            result.setCode(expCode);
            result.setS(Arrays.asList(expWords));

            requests[i] = request;
            results[i] = result;
            Object[] reqAndRes = new Object[]{requests[i], results[i]};
            allData[i] = reqAndRes;
        }
        return allData;
    }
}
