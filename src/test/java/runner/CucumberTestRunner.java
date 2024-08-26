package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/InternetHerokuApp", // Path to your feature files
        glue = "stepDefinitions",      // Package where your step definitions are located
        tags = "@Login"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
