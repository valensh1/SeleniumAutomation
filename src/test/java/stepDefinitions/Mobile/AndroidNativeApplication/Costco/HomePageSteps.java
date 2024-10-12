package stepDefinitions.Mobile.AndroidNativeApplication.Costco;

import Mobile.AndroidNativeApplication.Costco.Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java8.En;
import stepDefinitions.Hooks;

public class HomePageSteps implements En {
    private AndroidDriver driver;
    private HomePage homePage;

    public HomePageSteps() {
        Before(() -> {
            driver = Hooks.getAndroidDriver();
            homePage = new HomePage(driver);
        });

        Then("^I verify my set warehouse displays on home page$" , () -> {
            homePage.verifySetWarehouse();
        });
    }
}
