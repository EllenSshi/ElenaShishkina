package hw8;

import hw8.dto.SpellResultDto;
import hw8.service.PropertyService;
import hw8.service.RestSpellerAssertions;
import hw8.service.RestSpellerService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class CheckTextTest {

    public final int code = new PropertyService().getErrorUnknownWord();
    public final String eng = new PropertyService().getEnglishLang();
    public final String rus = new PropertyService().getRussianLang();

    @Test
    public void checkTextWithOneIncorrectWord() throws IOException {
        String text = "Hello my mstake";
        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, eng);
        new RestSpellerAssertions(spellRes)
                .verifySpellResult(code, Arrays.asList("mistake","mistakes","mistaken"));
    }

    @Test
    public void checkTextWithTwoIncorrectWords() throws IOException {
        String text = "vegetubles are potatous and carrots";
        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, eng);
        new RestSpellerAssertions(spellRes)
                .verifySpellResults(new Integer[] {code, code},
                        Arrays.asList(Collections.singletonList("vegetables"),
                        Arrays.asList("potatoes","potatos","potato")));
    }

    @DataProvider
    public Object[][] spellerData() {
        return new Object[][]{
                {"unpredectable", eng, code, "unpredictable","unpredictably","predictable"},
                {"fasinating", eng, code, "fascinating","facinating","facsinating"},
                {"aple", eng, code, "apple","maple","able"},
        };
    }

    @Test(dataProvider = "spellerData")
    void checkTextWithDataProvider(String text, String lang, int code, String... expectedS) throws IOException {

        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, lang);
        new RestSpellerAssertions(spellRes)
                .verifySpellResult(code, Arrays.asList(expectedS));
    }
}
