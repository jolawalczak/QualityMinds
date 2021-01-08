package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class KontaktPage extends BasePage {

    private static String xpathKontaktAnfraht = "//span[text()=\"Kontakt & Anfahrt\"]";

    public static void kontaktPage() {

        wait5(xpathKontaktAnfraht);
        log.info("Kontakt & Anfahrt page is displayed");

    }

    public static void verifyEmail(String emailAddress) {

        String xpathEmail = "//a[text()=\"" + emailAddress + "\"]";
        driver.findElement(By.xpath(xpathEmail));
        log.info("Page contains " + emailAddress + " email address");

    }

    public static void navigateBack() {
        driver.navigate().back();
        log.info("Navigate back to www.qualityminds.de main page");
    }
}
