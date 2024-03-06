package dataProviders;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {
    private final String propertyFilePath = "src/test/resources/config/configuration.properties";

    public Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            log.info("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}