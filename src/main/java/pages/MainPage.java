package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utilities.BasePage;

@Slf4j
public class MainPage extends BasePage {

    private static String xpathImg = "//img[@alt=\"QualityMinds\"]";
    private static String xpathKontakt = "//ul[@id=\"top-menu\"]//a[text()=\"Kontakt\"]";
    private static String xpathKontaktAnfraht = "//a[text()=\"Kontakt & Anfahrt\"]";
    private static String xpathPortfolio = "//ul[@id=\"top-menu\"]//a[text()=\"Portfolio\"]";
    private static String xpathPortfolioSubmenu = "//ul[@id=\"top-menu\"]/li[2]/ul[@class=\"sub-menu\"]";
    private static String getXpathPortfolioSubmenuWeb = xpathPortfolioSubmenu + "//a[text()=\"Web, Automation & Mobile Testing\"]";
    private static String xpathKarriere = "//ul[@id=\"top-menu\"]//a[text()=\"Karriere\"]";


    public static void mainPage(String url) {

        driver.get("https://" + url);

        wait15(xpathImg);
        log.info("QualityMinds page is opened");
    }

    public static void mainPageDisplayed() {

        wait15(xpathImg);
        log.info("QualityMinds page is displayed");
    }

    public static void clickKontact() {

        wait5(xpathKontakt);
        driver.findElement(By.xpath(xpathKontakt)).click();
        log.info("Click on \"Kontakt\"");

    }

    public static void clickKontaktAnfraht() {

        wait5(xpathKontaktAnfraht);
        driver.findElement(By.xpath(xpathKontaktAnfraht)).click();
        log.info("Click on \"Kontakt & Anfahrt\"");
    }

    public static Boolean goToPortfolio() throws InterruptedException {
        Boolean display=false;

            wait5(xpathPortfolio);

            builder.moveToElement(driver.findElement(By.xpath(xpathPortfolio))).build().perform();
            log.info("Hover on Portfolio at the top navigation bar of the page");
            display = driver.findElement(By.xpath(xpathPortfolioSubmenu)).isDisplayed();
            if (display) {
                log.info("Submenu is displayed");
            } else {
                log.info("Submenu is not displayed");
            }


        return display;
    }

    public static void clickOnWebAutomationMobileTesting() {

        driver.findElement(By.xpath(getXpathPortfolioSubmenuWeb)).click();
        log.info("Click on Web, Automation & Mobile Testing sub option");
    }


    public static void clickKarriere() {

        wait5(xpathKarriere);
        driver.findElement(By.xpath(xpathKarriere)).click();
        log.info("Click on \"Karriere\"");
    }

}
