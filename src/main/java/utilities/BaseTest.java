package utilities;

import browsers.Chrome;
import io.cucumber.core.api.Scenario;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

        @Setter @Getter private static WebDriver driver;
        protected static String browser;
        protected static GetProperties getProperties;

        public void startDriver (Scenario scenario) throws IOException {

                getProperties = new GetProperties();
                Properties properties = getProperties.getProperties();
                browser = properties.getProperty("browser");

                if (browser.equalsIgnoreCase("chrome")) {
                        driver = Chrome.getDriver();
                }

//                if (browser.equalsIgnoreCase("firefox")) {
//                        driver = Chrome.getDriver();
//                }


                properties.setProperty("browser.version", ((RemoteWebDriver)driver).getCapabilities().getVersion());
                driver.manage().window().maximize();
        }


        public static void stopDriver() {

                if (driver != null) driver.quit();
        }
}
