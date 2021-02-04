package hw8;

import hw6.JDITestData;
import hw8.dto.SpellRequestDto;
import hw8.dto.SpellResultDto;
import hw8.dto.SpellTestData;
import hw8.service.RestSpellerAssertions;
import hw8.service.RestSpellerService;
import hw8.service.constants.ErrorCode;
import hw8.service.constants.Language;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class CheckTextTest {
    @Test
    public void checkCorrectText() throws IOException {
        String text = "This is a sentence without any mistakes";
        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, Language.ENGLISH);
        new RestSpellerAssertions(spellRes)
                .verifyEmptySpellResult();
    }

    @Test
    public void checkTextWithOneIncorrectWord() throws IOException {
        String text = "Hello my mstake";
        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, Language.ENGLISH);
        new RestSpellerAssertions(spellRes)
                .verifySpellResult(ErrorCode.ERROR_UNKNOWN_WORD,
                        Arrays.asList("mistake","mistakes","mistaken"));
    }

    @Test
    public void checkTextWithTwoIncorrectWords() throws IOException {
        String text = "vegetubles are potatous and carrots";
        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, Language.ENGLISH);
        new RestSpellerAssertions(spellRes)
                .verifySpellResults(new Integer[] {ErrorCode.ERROR_UNKNOWN_WORD, ErrorCode.ERROR_UNKNOWN_WORD},
                        Arrays.asList(Collections.singletonList("vegetables"),
                        Arrays.asList("potatoes","potatos","potato")));
    }

    @DataProvider
    public Object[][] spellerData() {
        return new Object[][]{
                {"unpredectable", Language.ENGLISH, ErrorCode.ERROR_UNKNOWN_WORD, "unpredictable","unpredictably","predictable"},
                {"fasinating", Language.ENGLISH, ErrorCode.ERROR_UNKNOWN_WORD, "fascinating","facinating","facsinating"},
                {"aple", Language.ENGLISH, ErrorCode.ERROR_UNKNOWN_WORD, "apple","maple","able"},
        };
    }

    @Test(dataProvider = "spellerData")
    void checkTextWithDataProvider(String text, String lang, int code, String... expectedS) throws IOException {

        SpellResultDto[] spellRes = new RestSpellerService().checkText(text, lang);
        new RestSpellerAssertions(spellRes)
                .verifySpellResult(code, Arrays.asList(expectedS));
    }

    @Test(dataProvider = "spellerTestData", dataProviderClass = SpellTestData.class)
    void checkTextWithDataFromFile(Object[] reqAndRes) throws IOException {
        SpellRequestDto req = (SpellRequestDto) reqAndRes[0];
        SpellResultDto resp = (SpellResultDto) reqAndRes[1];
        SpellResultDto[] spellRes = new RestSpellerService().checkText(req.getText(), req.getLang());

        new RestSpellerAssertions(spellRes)
                .verifySpellResult(resp.getCode(), resp.getS());
    }
}
