package browsers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox {

    public static WebDriver getDriver() {
        FirefoxDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions());
    }

    public static FirefoxOptions firefoxOptions() {

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.folderList",2);
        firefoxOptions.addPreference("browser.download.manager.showWhenStarting",false);
        firefoxOptions.addPreference("browser.download.dir", System.getProperty("user.dir") + "\\src\\main\\resources\\files\\");
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        firefoxOptions.addPreference("dom.webnotifications.enabled", false);
        firefoxOptions.addPreference("privacy.socialtracking.block_cookies.enabled", false);
        firefoxOptions.addPreference("pdfjs.disabled", true);
        firefoxOptions.addPreference("pdfjs.enablePermissions",true);
        firefoxOptions.addPreference("pdfjs.disableStream",true);


        return firefoxOptions;
    }

}
