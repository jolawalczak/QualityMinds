package stepdefs;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseTest;

import java.io.IOException;

public class Hook extends BaseTest{

    @Before
    public void begin(Scenario scenario) throws IOException {
        startDriver(scenario);
    }



    @After
    public static void tearDownTest(Scenario scenario) throws IOException {
        stopDriver();
    }

}
