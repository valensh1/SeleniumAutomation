package stepDefinitions.InternetHerokuApp;
import InternetHerokuApp.pages.AppUtils;
import io.cucumber.java8.En;
import stepDefinitions.Hooks;


public class NavigationSteps implements En {
    private AppUtils appUtils;

    public NavigationSteps() {

        When("^I navigate to the (.+) page$", (String page) -> {
            appUtils = new AppUtils(Hooks.getDriver(), page);
            appUtils.navigateToPage();
        });
    }
}
