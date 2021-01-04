package stepdefs;

import io.cucumber.java.en.Given;
import pages.MainPage;

public class UIStepDefinitions {


    @Given("^A user go to main page$")
    public void a_user_go_to_main_page() {
        MainPage.mainPage();
    }
}
