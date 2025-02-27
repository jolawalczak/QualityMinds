package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

    private Properties properties;

    public Properties getProperties() throws IOException {

        properties = new Properties();
        String fileName = "test.properties";

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (Exception e) {
            throw new FileNotFoundException("File: " + fileName + " not fount");
        }
        return properties;
    }

}
