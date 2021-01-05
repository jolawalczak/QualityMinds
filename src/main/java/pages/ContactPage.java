package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class ContactPage extends BasePage {


    public static void contactPage() {

        xpath = "//span[text()=\"Kontakt & Anfahrt\"]";
        waitForElement(xpath, 5);
        log.info("Kontakt & Anfahrt page is displayed");
    }

    public static void verifyEmail() {

        xpath = "//a[text()=\"hello@qualityminds.de\"]";
        driver.findElement(By.xpath("//a[text()=\"hello@qualityminds.de\"]"));
        log.info("Page contains hello@qualityminds.de email address");

    }

    public static void navigateBack() {
        driver.navigate().back();
        log.info("Navigate back to www.qualityminds.de main page");
    }
}
