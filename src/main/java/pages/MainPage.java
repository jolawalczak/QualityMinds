package pages;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class MainPage extends BasePage {

    public static void mainPage() {

        String url = "https://qualityminds.de/";
        driver.get(url);

        xpath = "//img[@alt=\"QualityMinds\"]";
        waitForElement(xpath, 10);
        log.info("QualityMinds page is opened");
    }

    public static void mainPageDisplayed() {

        xpath = "//img[@alt=\"QualityMinds\"]";
        waitForElement(xpath, 10);
        log.info("QualityMinds page is displayed");
    }

    public static void clickKontact() {

        xpath = "//ul[@id=\"top-menu\"]//a[text()=\"Kontakt\"]";
        waitForElement(xpath, 5);
        driver.findElement(By.xpath(xpath)).click();
        log.info("Click on \"Kontakt\"");

    }

    public static void clickKontaktAnfraht() {

        xpath = "//a[text()=\"Kontakt & Anfahrt\"]";
        waitForElement(xpath, 5);
        driver.findElement(By.xpath(xpath)).click();
        log.info("Click on \"Kontakt & Anfahrt\"");

    }



}
