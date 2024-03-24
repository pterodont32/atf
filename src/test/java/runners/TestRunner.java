package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"hooks","stepDefinition"},
        stepNotifications =  true,
        plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html" },
        monochrome = true

)

public class TestRunner {
}