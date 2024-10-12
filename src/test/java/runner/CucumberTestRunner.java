package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "stepDefinitions",      // Package where your step definitions are located
        tags = "@smv"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    // INSERT ANY METHOD HERE WITH CODE THAT YOU WANT TO RUN BEFORE ANY CUCUMBER STEPS BEGIN
    /*
    @BeforeClass
    public void testPractice() {
        System.out.println("Running before any Cucumber tests.");
    }
     */
}
