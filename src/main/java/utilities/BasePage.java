package utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

@Slf4j
public class BasePage extends BaseTest {

    //protected static WebDriver driver = BaseTest.getDriver();
    public static WebDriverWait wait5 = new WebDriverWait(driver, 5);
    public static WebDriverWait wait15 = new WebDriverWait(driver, 15);
    protected static Actions builder = new Actions(driver);


    public static void wait5(String xpath) {
        try {
            wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            log.info(e.toString());
        }
    }

    public static void wait15(String xpath) {
        try {
            wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            log.info(e.toString());
        }
    }

    public static void wait5Multi(String xpath) {
        try {
            wait5.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
        } catch (Exception e) {
            log.info(e.toString());
        }
    }

    public static String returnSourcePage() {
        String sourcePage = driver.getPageSource();
        return sourcePage;
    }

    public static Robot robot() throws AWTException {
        Robot robot = new Robot();
        robot.delay(3000);
        return robot;
    }

}
