package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

import java.io.File;

@Slf4j
public class WebAutMobTestPage extends BasePage {

    private static String xpathTextWebAutMobTest = "//span[text()=\"Web, Automation & Mobile Testing\"]";
    private static String xpathPortfolio = "//ul[@id=\"top-menu\"]//a[text()=\"Portfolio\"]";
    private static String xpathMobile = "//div[@id=\"team-tab-three-title-desktop\"]/div[text()=\"Mobile\"]";
    private static String xpathMobileSection = "//div[@id=\"team-tab-three-body\"]";
    private static String xpathUnderlieMobile = "//div[@id=\"main-content\"]/div[@id=\"et-boc\"]/div/div/div/div[3]";
    private static String xpathButtonFlayer = "//a[text()=\"Flyer Find the Bug Session\"]";

    public static void webAutMobTestPage() {

        wait15(xpathTextWebAutMobTest);
        log.info("Web, Automation & Mobile testing page is displayed");
    }

    public static Boolean verifyPortfolioHighlighted() {

        Boolean verifyPortfolioHighlighted = false;

        String color = driver.findElement(By.xpath(xpathPortfolio)).getCssValue("color");

        if (color.contains("130, 186, 69")) {
            verifyPortfolioHighlighted = true;
        };

        return verifyPortfolioHighlighted;
    }

    public static void clickMobile() {

        driver.findElement(By.xpath(xpathMobile)).click();
        log.info("Click on Mobile tab in \"Web - Automatisierung - Mobile\" section");

    }

    public static Boolean mobile() {

        Boolean mobile = false;

        Boolean mobileSection = driver.findElement(By.xpath(xpathMobileSection)).isDisplayed();
        if(mobileSection) { log.info("Mobile section content is displayed"); }
        else { log.info("Mobile section content is not displayed"); }

        Boolean mobileGrey = false;
        String color = driver.findElement(By.xpath(xpathUnderlieMobile)).getCssValue("border-bottom-color");
        if(color.contains("151, 151, 151")) {
            mobileGrey=true;
            log.info("\"Mobile\" is underlined in grey");
        } else {log.info("\"Mobile\" is not underlined in grey");}

        Boolean Flayer = driver.findElement(By.xpath(xpathButtonFlayer)).isDisplayed();
        if(Flayer) { log.info("\"Flayer find the bug session\" button is displayed on the right"); }
        else { log.info("\"Flayer find the bug session\" button is not displayed"); }

        if (mobileSection && mobileGrey && Flayer) { mobile = true;}

        return mobile;
    }


    public static WebElement downloadLink() {
        WebElement downloadlink = driver.findElement(By.xpath(xpathButtonFlayer));
        log.info("Verify the download link for the flyer");
        return downloadlink;
    }

    public static boolean file() throws InterruptedException {

        boolean file = false;

        driver.findElement(By.xpath(xpathButtonFlayer)).click();
        log.info("Go to dowloaded link by button");

        Thread.sleep(5000);

        try {

            File folder = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\files\\");
            File[] listOfFiles = folder.listFiles();
            String fileName;

            int count = 0;

            do {

                for (int i = 0; i < listOfFiles.length; i++) {

                    if (listOfFiles[i].isFile()) {
                        fileName = listOfFiles[i].getName();

                        if (fileName.equals("Find-The-Mobile-Bug-Session.pdf") || fileName.equals("FLYER FIND THE BUG SESSION.pdf")) {

                            log.info("File " + fileName + " exist in downloaded folder");
                            count = 10;
                            file = true;

                            listOfFiles[i].delete();
                            log.info("Delete downloaded file");

                        } else { count++; }
                    }
                }

                Thread.sleep(1000);

            } while (listOfFiles.length == 0 || count < 10);

        } catch (Exception e) {
            log.info(e.toString());
        }

        return file;

    }
}
