package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(

            features = "src/test/resources/features",
            plugin = {"pretty", "json:target/report/Cucumber.json"},
            tags = {"@Test3"},
            stepNotifications = true,
            glue = "stepdefs"
    )

public class TestRunnerJunit { }