package runners;


import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static utils.PropertyUtils.getPropertyFromConfigFile;
import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"hooks","stepDefinition"}

)

public class TestRunner {

}