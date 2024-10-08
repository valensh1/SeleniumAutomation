package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.AppUtilities;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class NavigationSteps implements En {
    private WebDriver driver;

    public NavigationSteps() {
        // Use a Before hook to ensure driver and pages are initialized before any step runs
        Before(() -> {
            this.driver = Hooks.getDriver();
        });

        When("^I navigate to the (.+) page$", (String page) -> {
            AppUtilities.navigateToPage(driver, page);
        });
    }
}
