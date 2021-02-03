package hw8.service;

import com.google.gson.Gson;
import hw8.dto.SpellResultDto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestSpellerService extends CommonService {
    public RestSpellerService() throws IOException {
    }

    public SpellResultDto[] checkText(String text, String lang) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("text", text);
        params.put("lang", lang);

        return
                new Gson().fromJson(
                        getWithParams(new PropertyService().getCheckTextEP(), params)
                                .getBody().asString(), SpellResultDto[].class);
    }

    public SpellResultDto[] checkTexts(String[] text, String lang) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("text", text);
        params.put("lang", lang);

        return
                new Gson().fromJson(
                        getWithParams(new PropertyService().getCheckTextEP(), params)
                                .getBody().asString(), SpellResultDto[].class);
    }
}
