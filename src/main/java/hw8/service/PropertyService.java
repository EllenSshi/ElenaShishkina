package hw8.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {
    protected String domain;
    protected String checkTextEP;
    protected String checkTextsEP;
    protected String englishLang;
    protected String russianLang;
    protected int errorUnknownWord;

    public PropertyService() {
        try (InputStream input = new FileInputStream("testapi.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value
            domain = prop.getProperty("DOMAIN");
            checkTextEP = prop.getProperty("CHECKTEXT");
            checkTextsEP = prop.getProperty("CHECKTEXTS");
            englishLang = prop.getProperty("ENGLISH");
            russianLang = prop.getProperty("RUSSIAN");
            errorUnknownWord = Integer.parseInt(prop.getProperty("ERROR_UNKNOWN_WORD"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getDomain() {
        return domain;
    }

    public String getCheckTextEP() {
        return checkTextEP;
    }

    public String getCheckTextsEP() {
        return checkTextsEP;
    }

    public String getEnglishLang() {
        return englishLang;
    }

    public String getRussianLang() {
        return russianLang;
    }

    public int getErrorUnknownWord() {
        return errorUnknownWord;
    }
}
