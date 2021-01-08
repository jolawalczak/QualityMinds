package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.BasePage;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class UIStepDefinitions {

    String sourcePageStep2 = null;
    String sourcePageStep5 = null;

    @Given("^Go to (.*) URL$")
    public void go_to_URL(String url) {
        MainPage.mainPage(url);
    }

    @And("^Click on \"Kontakt\" at the top navigation bar of the page$")
    public void click_on_kontakt() {
        MainPage.clickKontact();
        sourcePageStep2 = BasePage.returnSourcePage();
        KontaktPage.kontaktPage();
    }

    @Then("Verify if the page contains email address (.*)")
    public void verify_if_the_page_contains_email_address(String emailAddress) throws InterruptedException {
        KontaktPage.verifyEmail(emailAddress);
    }


    @And("^Navigate back to www.qualityminds.de main page$")
    public void navigate_back_to_main_page() {
        KontaktPage.navigateBack();
        MainPage.mainPageDisplayed();
    }

    @And("^Click on Kontakt & ANFAHRT link at the bottom of the page$")
    public void click_on_kontakt_anfahrt() {
        MainPage.clickKontaktAnfraht();
        KontaktPage.kontaktPage();

    }

    @Then("^Verify if the page displayed in step 2 is the same page that is displayed in step 5$")
    public void verify_if_the_page_displayed() {
        sourcePageStep5 = BasePage.returnSourcePage();
        assertThat(sourcePageStep2).isEqualTo(sourcePageStep5);
        log.info("Page displayed in step 2 and 5 are the same");
    }

    @And("^Hover on Portfolio at the top navigation bar of the page and verify if submenu is displayed$")
    public void go_to_portfolio_and_verify() throws InterruptedException {
        Boolean display = MainPage.goToPortfolio();
        assertThat(display).isEqualTo(true);
        log.info("Submenu is displayed");
    }

    @And("^Click on Web, Automation & Mobile Testing sub option$")
    public void click_on_web() {
        MainPage.clickOnWebAutomationMobileTesting();
        WebAutMobTestPage.webAutMobTestPage();
    }

    @Then("^Verify that the Portfolio item of the top bar menu is highlighted$")
    public void verify_that_the_portfolio_is_highlighted() {
        Boolean verify = WebAutMobTestPage.verifyPortfolioHighlighted();
        assertThat(verify).isEqualTo(true);
        log.info("Portfolio item of the top bar menu is highlighted");
    }

    @And("^Click on Mobile tab in \"Web - Automatisierung - Mobile\" section$")
    public void click_on_mobile_tab() {
        WebAutMobTestPage.clickMobile();
        Boolean mobile = WebAutMobTestPage.mobile();
        assertThat(mobile).isEqualTo(true);
    }

    @Then("^Verify the download link for the flyer$")
    public void verify_the_download_link() {
        WebElement downloadLink = WebAutMobTestPage.downloadLink();
        assertThat(downloadLink.getAttribute("href")).isEqualTo("https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf");
        log.info("Link is https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf");
    }

    @Then("^Verify if file is available via downloaded link$")
    public void verify_if_file_is_available() throws InterruptedException, AWTException {
        Boolean file = WebAutMobTestPage.file();
        assertThat(file).isEqualTo(true);
        log.info("File can be downloaded");
    }

    @And("^Click on the Karriere link in top navigation bar$")
    public void click_on_karriere() {
        MainPage.clickKarriere();
        KarrierePage.karrierePage();
    }

    @And("^Click on Bewirb Dich Jetzt! button$")
    public void click_on_bewibr() {
        KarrierePage.bawirbButton();
        ApplicationForm.applicationForm();
    }

    @And("^Click on Jetzt bewerben button$")
    public void click_on_jetzt() {
        ApplicationForm.clickJetz();
    }

    @Then("^Verify if validation messages are displayed$")
    public void verify_if_validation_messages_are_displayed() {
        ApplicationForm.validationMessages();
    }

    @And("^Fill the Vorname and Nachname field$")
    public void fill_the_vorname_and_nachname_field() {
        ApplicationForm.fillFieldsVorNach();
    }

    @And("^Fill the E-mail field with an Invalid value$")
    public void fill_the_email_field() {
        ApplicationForm.fillFieldsEmail();
    }


    @And("^Attach file with DATEIN HOCHLADEN button$")
    public void attach_file() throws AWTException {
        ApplicationForm.attachFile();
        boolean checkFileName = ApplicationForm.checkFileName();
        assertThat(checkFileName).isEqualTo(true);
    }

    @Then("^Check the checkbox for Datenschutzerklarung$")
    public void check_the_checkbox() {
        boolean checkCheckbox = ApplicationForm.checkCheckbox();
        assertThat(checkCheckbox).isEqualTo(true);
    }
}
