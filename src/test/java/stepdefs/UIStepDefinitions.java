package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.BasePage;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UIStepDefinitions {

    String sourcePageStep2 = null;

    @Given("^Go to (.*) URL$")
    public void go_to_URL(String url) {
        MainPage.mainPage(url);
    }

    @And("^Click on Kontakt$")
    public void click_on_kontakt() {
        MainPage.clickKontact();
        ContactPage.contactPage();
    }

    @Then("Verify if the page contains email address")
    public void verify_if_the_page_contains_email_address() throws InterruptedException {
        ContactPage.verifyEmail();
        String sourcePageStep2 = BasePage.returnSourcePage();
    }


    @And("^Navigate back to main page$")
    public void navigate_back_to_main_page() {
        ContactPage.navigateBack();
        MainPage.mainPageDisplayed();
    }

    @And("^Click on Kontakt & ANFAHRT$")
    public void click_on_kontakt_anfahrt() {
        MainPage.clickKontaktAnfraht();
        ContactPage.contactPage();

    }

    @Then("^Verify if the page displayed$")
    public void verify_if_the_page_displayed() {
        String sourcePageStep5 = BasePage.returnSourcePage();
        assertThat(sourcePageStep2).isEqualTo(sourcePageStep2);
    }

    @And("^Go to Portfolio and verify$")
    public void go_to_portfolio_and_verify() throws InterruptedException {
        Boolean display = MainPage.goToPortfolio();
        assertThat(display).isEqualTo(true);
    }

    @And("^Click on Web$")
    public void click_on_web() {
        MainPage.clickOnWebAutomationMobileTesting();
        WebAutMobTestPage.webAutMobTestPage();
    }

    @Then("^Verify that the Portfolio is highlighted$")
    public void verify_that_the_portfolio_is_highlighted() {
        Boolean verify = WebAutMobTestPage.verifyPortfolioHighlighted();
        assertThat(verify).isEqualTo(true);
    }

    @And("^Click on Mobile tab$")
    public void click_on_mobile_tab() {
        WebAutMobTestPage.clickMobile();
        Boolean mobile = WebAutMobTestPage.mobile();
        assertThat(mobile).isEqualTo(true);
    }

    @Then("^Verify the download link$")
    public void verify_the_download_link() {
        WebElement downloadLink = WebAutMobTestPage.downloadLink();
        assertThat(downloadLink.getAttribute("href")).isEqualTo("https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf");
    }

    @Then("^Verify if file is available$")
    public void verify_if_file_is_available() throws InterruptedException, AWTException {
        Boolean file = WebAutMobTestPage.file();
        assertThat(file).isEqualTo(true);
    }

    @And("^Click on Karriere$")
    public void click_on_karriere() {
        MainPage.clickKarriere();
        KarrierePage.karrierePage();
    }

    @And("^Click on Bewirb$")
    public void click_on_bewibr() {
        KarrierePage.bawirbButton();
        ApplicationForm.applicationForm();
    }

    @And("^Click on Jetzt$")
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

    @And("^Fill the Email field$")
    public void fill_the_email_field() {
        ApplicationForm.fillFieldsEmail();
    }


    @And("^Attach file$")
    public void attach_file() throws AWTException {
        ApplicationForm.attachFile();
        boolean checkFileName = ApplicationForm.checkFileName();
        assertThat(checkFileName).isEqualTo(true);
    }

    @Then("^Check the checkbox$")
    public void check_the_checkbox() {
        boolean checkCheckbox = ApplicationForm.checkCheckbox();
        assertThat(checkCheckbox).isEqualTo(true);
    }
}
