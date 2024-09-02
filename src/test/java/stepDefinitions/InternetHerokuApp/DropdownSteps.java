package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.AppUtilities;
import InternetHerokuApp.pages.DropdownPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class DropdownSteps implements En {
    private WebDriver driver;
    private DropdownPage dropdownPage;

    public DropdownSteps() {
        Before(() -> {
            driver = Hooks.getDriver();
            dropdownPage = new DropdownPage(driver);
        });

        Then("^I should be redirected to the Dropdown page$", (DataTable dataTable) -> {
            dropdownPage.verifyDropdownPageLoaded(dataTable.asMap(String.class, String.class));
        });

        When("^I select (.+) from the dropdown menu$", (String optionText) -> {
            dropdownPage.dropdownMenuSelectionByText(optionText);
        });

        When("^I verify dropdown displays my selection$", () -> {
            dropdownPage.verifyDropdownSelection();
        });

        When("^I refresh the page$", () -> {
            AppUtilities.refreshPage(driver);
        });

        Then("^I verify dropdown resets to default option$", (DataTable datatable) -> {
            dropdownPage.verifyDefaultDropdownStatus(datatable.asMap(String.class, String.class));
        });
    }
}
