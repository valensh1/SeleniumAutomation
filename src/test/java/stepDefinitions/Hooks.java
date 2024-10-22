package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import runner.AndroidSetup;
import runner.iOSSetup;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

public class Hooks {


    @Getter
    @Setter
    private static WebDriver driver;

    @Getter
    @Setter
    private static IOSDriver iosDriver;

    @Getter
    @Setter
    private static AndroidDriver androidDriver;

    // This Cucumber Hook runs BEFORE any scenario; Set order to 0 to avoid race condition because step definition tries to getDriver in Before method prior to this hook being completed
    @Before(order = 0)
    public void setup(Scenario scenario) throws MalformedURLException, URISyntaxException {
        // Check for the @iOS tag in the scenario
        if (scenario.getSourceTagNames().contains("@iOS")) {
            System.out.println("Setting up IOSDriver...");
            setIosDriver(iOSSetup.initializeDriver());
            if (iosDriver != null) {
                iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        } else if (scenario.getSourceTagNames().contains("@Android")) {
            System.out.println("Setting up Android Driver...");
            setAndroidDriver(AndroidSetup.initializeDriver());
            if (androidDriver != null) {
                androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        } else if (scenario.getSourceTagNames().contains("@APIOnly")) {
            System.out.println("No browser window to open --> API Calls being made");
        } else {
            System.out.println("Setting up WebDriver...");
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
            if (driver != null) {
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                System.out.println("Browser launched successfully");
            }
        }
    }

    @After
    public void teardown(Scenario scenario) {
        if (!scenario.getSourceTagNames().contains("@APIOnly")) {
            if (driver != null) {
                driver.quit();
                driver = null;
                System.out.println("Browser closed.");
            }
        }
        if (iosDriver != null) {
            iosDriver.quit();
            iosDriver = null;
            System.out.println("IOSDriver closed.");
        }
        if (androidDriver != null) {
            try {
                androidDriver.quit();
                System.out.println("Android Driver closed.");
            } catch (Exception e) {
                System.err.println("Error during AndroidDriver quit: " + e.getMessage());
            } finally {
                androidDriver = null;
                System.out.println("Android Driver set to null.");
            }
        }
    }
}