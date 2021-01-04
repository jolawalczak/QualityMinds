package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions());
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        return options;
    }
}
