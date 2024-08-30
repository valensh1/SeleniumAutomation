package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.AddRemoveElementsPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class AddRemoveElementsSteps implements En {
    private WebDriver driver;
    private AddRemoveElementsPage addRemoveElementsPage;
    private int buttonCount = 0;

    public AddRemoveElementsSteps() {
        Before(() -> {
            // Use a Before hook to ensure driver and pages are initialized before any step runs
            this.driver = Hooks.getDriver();
            addRemoveElementsPage = new AddRemoveElementsPage(driver);
        });

        Then("^I should be redirected to the Add/Remove Elements page$", () -> {
            addRemoveElementsPage.verifyAddRemoveElementsPageLoaded();
        });

        When("^I click on (.+) button (.+) times$", (String button, String count) -> {
            int clickCount = Integer.parseInt(count);
            buttonCount = button.equalsIgnoreCase("add element") ? buttonCount + clickCount : buttonCount - clickCount;
            addRemoveElementsPage.clickButtonNumTimes(button, clickCount);
        });

        Then("^I validate number of buttons displayed$", () -> {
                addRemoveElementsPage.validateNumberOfButtonsDisplayed(buttonCount);
        });
    }
}
