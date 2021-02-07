package hw8.service;

import hw8.dto.SpellResultDto;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;

public class RestSpellerAssertions {
    SpellResultDto[] spellResult;

    public RestSpellerAssertions(SpellResultDto[] response) {
        this.spellResult = response;
    }

    public RestSpellerAssertions verifySpellResult(int code, List<String> correctWords) {
        assertEquals(spellResult.length, 1, "Incorrect list of spellResult size");
        assertEquals(spellResult[0].getCode(), code, "Incorrect error code");
        assertEquals(spellResult[0].getS(), correctWords, "Incorrect list of expected correct words");
        return this;
    }

    public void verifyEmptySpellResult() {
        assertEquals(spellResult.length, 0, "Result is not empty");
    }

    public void verifySpellResults(Integer[] code, List<List<String>> correctWords) {
        assertEquals(
                stream(spellResult).map(SpellResultDto::getCode).collect(toList()).toArray(new Integer[]{}),
                code,
                "Incorrect error codes");

        assertEquals(
                stream(spellResult).map(SpellResultDto::getS).collect(toList()),
                correctWords,
                "Incorrect ses");
    }
}
