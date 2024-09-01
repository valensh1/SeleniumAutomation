package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.AppUtilities;
import InternetHerokuApp.pages.ContextMenuPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class ContextMenuSteps implements En {
    private WebDriver driver;
    private ContextMenuPage contextMenuPage;

    public ContextMenuSteps() {
        Before(() -> {
            driver = Hooks.getDriver();
            contextMenuPage = new ContextMenuPage(driver);
        });

        Then("^I should be redirected to the Context Menu page$", (DataTable dataTable) -> {
            contextMenuPage.verifyContextMenuPageText(dataTable.asMap(String.class, String.class));
        });

        When("^I right-click on hot spot$", () -> {
            contextMenuPage.rightClickHotSpot();
        });

        Then("I verify alert message text", (DataTable dataTable) -> {
            contextMenuPage.verifyAlertMessageText(dataTable.asMap(String.class, String.class));
        });

        When("I click OK button to close alert message", () -> {
            AppUtilities.clickOKAlertMessage(driver);
        });
    }
}
