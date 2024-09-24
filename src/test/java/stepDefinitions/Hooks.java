package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    @Getter
    private static WebDriver driver;

    @Before(order = 0)
    public void setup(Scenario scenario) {
        // Scenario is used to receive tag names and if any of them contain @API then DO NOT open web browser
        if (!scenario.getSourceTagNames().contains("@API")) {
            System.out.println("Setting up WebDriver...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Set implicit wait here
            System.out.println("Browser launched successfully");
        }
    }

    @After
    public void teardown(Scenario scenario) {
        // Scenario is used to receive tag names and if any of them contain @API then DO NOT close web browser
        if (!scenario.getSourceTagNames().contains("@API")) {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed.");
            }
        }
    }
}
