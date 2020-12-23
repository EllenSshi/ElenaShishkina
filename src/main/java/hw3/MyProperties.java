package hw3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {
    protected String username;
    protected String password;
    protected String baseUrl;
    protected String fullUserName;
    protected String indexPagePath;
    protected String difElementsPagePath;

    public MyProperties() {
        try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            baseUrl = prop.getProperty("baseurl");
            fullUserName = prop.getProperty("fullusername");
            indexPagePath = prop.getProperty("indexpagepath");
            difElementsPagePath = prop.getProperty("difelementspagepath");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getFullUserName() { return fullUserName; }

    public String getIndexPagePath() { return indexPagePath; }

    public String getDifElementsPagePath() { return difElementsPagePath; }
}
