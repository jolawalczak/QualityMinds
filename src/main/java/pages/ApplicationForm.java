package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

import java.awt.*;
import java.util.List;

import static utilities.UploadFile.uploadFile;

@Slf4j
public class ApplicationForm extends BasePage {

    private static String xpathApplicationForm = "//form//h3[text()=\"Deine Daten\"]";
    private static String xpathJetzt = "//input[@value=\"Jetzt Bewerben\"]";
    private static String xpathFieldInput = "//input[@placeholder]";
    private static String xpathValidationMessageAll = "//span[@aria-live=\"polite\"]/span";
    private static String xpathFieldFrame = "//div[@id=\"CF5bcf0384b847c_1-row-1\"]/div/div";
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
            wait5Multi(xpathValidationMessageAll);
            log.info("Message is not submitted");
        } catch (Exception e) { log.info("Not visible validation messages"); }

    }

    public static void validationMessages() {

            wait5Multi(xpathValidationMessageAll);
            List<WebElement> fieldFrames = driver.findElements(By.xpath(xpathFieldFrame));

            int numberOfMessages = 0;

            for (int i = 1; i<=fieldFrames.size(); i++) {

                try {

                    String messageText = driver.findElement(By.xpath(xpathFieldFrame + "[" + i + "]" + xpathValidationMessageAll)).getText();
                    String typeFieldName = driver.findElement(By.xpath(xpathFieldFrame + "[" + i + "]" + xpathFieldInput)).getAttribute("placeholder");

                    if (typeFieldName.contains("Vorname") && messageText.contains("Dies ist ein Pflichtfeld.")) {
                        log.info("Validation message were displayed for Vorname field");
                        numberOfMessages++;
                    }
                    if (typeFieldName.contains("Nachname") && messageText.contains("Dies ist ein Pflichtfeld.")) {
                        log.info("Validation message were displayed for Nachname field");
                        numberOfMessages++;
                    }
                    if (typeFieldName.contains("Email") && (messageText.contains("Die Eingabe muss eine gültige E-Mail-Adresse sein.") || messageText.contains("Dies ist ein Pflichtfeld."))) {
                        log.info("Validation message were displayed for Email field");
                        numberOfMessages++;
                    }

                } catch (Exception e) {}
            }

        if (numberOfMessages==3) {
            log.info("Validation messages were displayed for 3 fields"); }

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
