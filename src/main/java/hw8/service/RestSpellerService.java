package hw8.service;

import com.google.gson.Gson;
import hw8.dto.SpellResultDto;
import hw8.service.constants.URI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestSpellerService extends CommonService {
    public RestSpellerService() throws IOException {
    }

    public SpellResultDto[] checkText(String text, String lang) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("text", text);
        params.put("lang", lang);

        return
                new Gson().fromJson(
                        getWithParams(URI.CHECK_TEXT, params)
                                .getBody().asString(), SpellResultDto[].class);
    }

    public SpellResultDto[] checkTexts(String[] text, String lang) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("text", text);
        params.put("lang", lang);

        return
                new Gson().fromJson(
                        getWithParams(URI.CHECK_TEXTS, params)
                                .getBody().asString(), SpellResultDto[].class);
    }
}
