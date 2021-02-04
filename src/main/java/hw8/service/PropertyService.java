package hw8.service;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class PropertyService {
    protected String domain;

    public PropertyService() {
        try (InputStream input = new FileInputStream("testapi.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value
            domain = prop.getProperty("DOMAIN");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
