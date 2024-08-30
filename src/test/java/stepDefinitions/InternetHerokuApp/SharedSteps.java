package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.AppUtilities;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class SharedSteps implements En {
    private WebDriver driver;

    public SharedSteps() {
        // Use a Before hook to ensure driver and pages are initialized before any step runs
        Before(() -> {
            this.driver = Hooks.getDriver();
        });

        When("^I click on (.+) (button|link)$", (String elementText, String element) -> {
            AppUtilities.clickElementByText(driver, elementText);
            Thread.sleep(2000);
        });

    }
}
