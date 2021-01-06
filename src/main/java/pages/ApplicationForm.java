package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class ApplicationForm extends BasePage {

    private static String xpathApplicationForm = "//form//h3[text()=\"Deine Daten\"]";
    private static String xpathJetzt = "//input[@value=\"Jetzt Bewerben\"]";
    private static String xpathEmptyForm = "//span[text()=\"Dies ist ein Pflichtfeld.\"]";


    public static void applicationForm() {

        wait5(xpathApplicationForm);
        log.info("An application form is opened");
    }

    public static void clickJetz() {

        driver.findElement(By.xpath(xpathJetzt)).click();
        log.info("Click on Jetzt bewerben button");
        wait5Multi(xpathEmptyForm);

        if (driver.findElements(By.xpath(xpathEmptyForm)).size()>0) {
            log.info("Message is not be submitted");
        }
    }

}
