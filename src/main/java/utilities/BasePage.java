package utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

@Slf4j
public class BasePage {

    protected static WebDriver driver = BaseTest.getDriver();
    public static WebDriverWait waitShort = new WebDriverWait(driver, 10);
    protected static String xpath = null;

    public static void waitForElement(String xpath, int seconds) {

        if (seconds!=10) {
            waitShort = new WebDriverWait(driver, seconds);
        }
        try {
            waitShort.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            log.info(e.toString());
        }
    }

    public static String returnSourcePage() {
        String sourcePage = driver.getPageSource();
        return sourcePage;
    }

}
