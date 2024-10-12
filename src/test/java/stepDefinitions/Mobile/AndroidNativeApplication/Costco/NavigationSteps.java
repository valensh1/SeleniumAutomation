package stepDefinitions.Mobile.AndroidNativeApplication.Costco;

import Mobile.AndroidNativeApplication.Costco.Pages.Navigations;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java8.En;
import stepDefinitions.Hooks;

public class NavigationSteps implements En {
    private AndroidDriver driver;
    private Navigations navigations;

    public NavigationSteps() {
        Before(() -> {
            driver = Hooks.getAndroidDriver();
            navigations = new Navigations(driver);
        });

        When("^I navigate to (.+) page$", (String page) -> {
            navigations.navigateToPage(driver, page);
        });
    }
}
