package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

import java.awt.*;

import static utilities.UploadFile.uploadFile;

@Slf4j
public class ApplicationForm extends BasePage {

    private static String xpathApplicationForm = "//form//h3[text()=\"Deine Daten\"]";
    private static String xpathJetzt = "//input[@value=\"Jetzt Bewerben\"]";
    private static String xpathValidationMessageFields = "//div[@id=\"CF5bcf0384b847c_1-row-1\"]";
    private static String xpathValidationMessage = "//span[text()=\"Dies ist ein Pflichtfeld.\"]";
    private static String xpathVorname = "//input[@placeholder=\"Vorname*\"]";
    private static String xpathNachname = "//input[@placeholder=\"Nachname*\"]";
    private static String xpathEmail = "//input[@placeholder=\"Email*\"]";
    private static String xpathDateinHochladen = "//button[text()=\"Dateien hochladen\"]";
    private static String xpathRemoveFile = "//button/span[text()=\"Remove file\"]";
    private static String xpathUploadFileName = "//span[contains(@class,\"file-name\")]";
    private static String xpathCheckbox = "//input[@type=\"checkbox\"]";

    private static String fileName = "text.txt";

    public static void applicationForm() {

        wait5(xpathApplicationForm);
        log.info("An application form is opened");
    }

    public static void clickJetz() {

        driver.findElement(By.xpath(xpathJetzt)).click();
        log.info("Click on Jetzt bewerben button");

        try {
            wait5Multi(xpathValidationMessage);
            log.info("Message is not be submitted");
        } catch (Exception e) { log.info("Not visible validation messages"); }

    }

    public static void validationMessages() {

        Boolean validationMessagesNotDisplayed = false;

        for (int i = 1; i<=3; i++) {
            try {
                WebElement message = driver.findElement(By.xpath(xpathValidationMessageFields + "//div[" + i + "]" + xpathValidationMessage));
                if (i==1) { log.info("Validation message was displayed for Vorname field"); }
                if (i==2) { log.info("Validation message was displayed for Nachname field"); }
                if (i==3) { log.info("Validation message was displayed for Email field"); }
            } catch (Exception e) {
                validationMessagesNotDisplayed = true;
            }
        }

        if(!validationMessagesNotDisplayed) { log.info("Validation messages were displayed for 3 fields"); }

    }

    public static void fillFieldsVorNach() {

        String vornameS = "Xxxxx";
        String nachnameS = "Yyyyy";

        String valueVorname = fillField(vornameS,xpathVorname);
        String valueNachname = fillField(nachnameS,xpathNachname);

        if (valueVorname.equals(vornameS) && valueNachname.equals(nachnameS)) {
            log.info("Fields are filled");
        } else { log.info("Fields not filled default values"); }

    }

    public static void fillFieldsEmail() {

        String emailS = "Zzzzz";

        String valueEmail = fillField(emailS,xpathEmail);

        if (valueEmail.equals(emailS)) {
            log.info("Email field is filled");
        } else { log.info("Email field is not filled default value"); }

    }

    public static String fillField(String value, String xpath) {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.sendKeys(value);
        return webElement.getAttribute("value");
    }

    public static void attachFile() throws AWTException {

        driver.findElement(By.xpath(xpathDateinHochladen)).click();
        log.info("Click on button Datein Hochladen");

        uploadFile(System.getProperty("user.dir") + "\\src\\main\\resources\\files\\" + fileName, robot());
        log.info("Upload file " + fileName);

    }

    public static boolean checkFileName() {

        boolean checkFileName = false;
        wait15(xpathRemoveFile);

        String uploadFileName = driver.findElement(By.xpath(xpathUploadFileName)).getText();
        log.info("Name of upload file " + uploadFileName);

        if (uploadFileName.equals(fileName)) {
            log.info("Filename of attachment is displayed above DATEIN HOCHLANDEN button");
            checkFileName=true;
        }

        return checkFileName;
    }

    public static boolean checkCheckbox() {

        boolean checkCheckbox = false;

        driver.findElement(By.xpath(xpathCheckbox)).click();
        if (driver.findElement(By.xpath(xpathCheckbox)).getAttribute("checked").equals("true")) {
            log.info("Checkbox is checked");
            checkCheckbox = true;
        }
        return checkCheckbox;
    }

}
