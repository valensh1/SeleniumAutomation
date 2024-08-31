package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.CheckboxesPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class CheckboxSteps implements En {
    private WebDriver driver;
    private CheckboxesPage checkboxesPage;

    public CheckboxSteps() {
        Before(() -> {
            // Use a Before hook to ensure driver and pages are initialized before any step runs
            driver = Hooks.getDriver();
            checkboxesPage = new CheckboxesPage(driver);
        });

        Then("^I should be redirected to the Checkboxes page$", () -> {
            checkboxesPage.verifyCheckboxesPageLoaded();
        });

        Then("^I verify checkbox (.+) is (checked|unchecked)$", (String checkboxNumber, String status) -> {
            System.out.println("This is the status " + status);
            checkboxesPage.isChecked(checkboxNumber, status);
        });

        When("^I click checkbox (.+)$", (String checkboxNumber) -> {
            checkboxesPage.clickCheckbox(checkboxNumber);
        });
    }
}


