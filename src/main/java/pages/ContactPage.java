package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class ContactPage extends BasePage {

    private static String xpathKontaktAnfraht = "//span[text()=\"Kontakt & Anfahrt\"]";
    private static String xpathEmail = "//a[text()=\"hello@qualityminds.de\"]";

    public static void contactPage() {

        wait5(xpathKontaktAnfraht);
        log.info("Kontakt & Anfahrt page is displayed");
    }

    public static void verifyEmail() {

        driver.findElement(By.xpath(xpathEmail));
        log.info("Page contains hello@qualityminds.de email address");

    }

    public static void navigateBack() {
        driver.navigate().back();
        log.info("Navigate back to www.qualityminds.de main page");
    }
}
