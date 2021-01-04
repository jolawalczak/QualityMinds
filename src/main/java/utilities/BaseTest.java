package utilities;

import gherkin.ast.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

        private static WebDriver driver;
        protected static String browser;
        protected static GetProperties getProperties;

        public void startTest (Scenario scenario) throws IOException {

                getProperties = new GetProperties();
                Properties properties = getProperties.getProperties();
                String browser = properties.getProperty("browser");
                System.out.println(browser);
        }
}
