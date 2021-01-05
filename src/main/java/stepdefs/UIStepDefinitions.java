package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ContactPage;
import pages.MainPage;
import utilities.BasePage;
import static org.assertj.core.api.Assertions.assertThat;

public class UIStepDefinitions {

    String sourcePageStep2 = null;

    @Given("^A user go to main page$")
    public void a_user_go_to_main_page() {
        MainPage.mainPage();
    }

    @And("^Click on contact$")
    public void click_on_contact() {
        MainPage.clickKontact();
        ContactPage.contactPage();
    }

    @Then("Verify if the page contains email address")
    public void verify_if_the_page_contains_email_address() {
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
        ContactPage.navigateBack();

    }

    @Then("Verify if the page displayed")
    public void verify_if_the_page_displayed() {
        String sourcePageStep5 = BasePage.returnSourcePage();
        assertThat(sourcePageStep2).isEqualTo(sourcePageStep2);
    }
}
