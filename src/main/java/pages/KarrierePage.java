package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class KarrierePage extends BasePage {

    private static String xpathText = "//h1/span[\"Werde ein QualityMind!\"]";
    private static String xpathBewirb = "//a[text()=\"Bewirb dich jetzt!\"]";


    public static void karrierePage() {

        wait5(xpathText);
        log.info("A Karriere page is displayed");
    }

    public static void bawirbButton() {

        driver.findElements(By.xpath(xpathBewirb)).get(1).click();
        log.info("Click on Bewirb Ditch Jetzt! button");

    }

}
