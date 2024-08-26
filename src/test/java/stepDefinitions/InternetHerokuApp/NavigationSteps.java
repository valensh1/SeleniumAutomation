package stepDefinitions.InternetHerokuApp;
import InternetHerokuApp.pages.AppUtilities;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class NavigationSteps implements En {
    WebDriver driver;

    public NavigationSteps() {

        When("^I navigate to the (.+) page$", (String page) -> {
            driver = Hooks.getDriver();
            AppUtilities.navigateToPage(driver, page);
        });
    }
}
