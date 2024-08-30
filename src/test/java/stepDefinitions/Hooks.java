package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;

    @Before(order = 0)
    public void setup() {
        System.out.println("Setting up WebDriver...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Set implicit wait here
        System.out.println("Browser launched successfully");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
