package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.BaseTest;

import java.util.HashMap;

public class Chrome {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions());
    }

    private static ChromeOptions chromeOptions() {

        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\src\\main\\resources\\files\\");
        chromePrefs.put("download.prompt_for_download", false);

        chromeOptions.setExperimentalOption("prefs", chromePrefs);


        return chromeOptions;
    }
}
