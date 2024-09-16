package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.AppUtilities;
import InternetHerokuApp.pages.MultipleWindowsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;


public class MultipleWindowsSteps implements En {
    private WebDriver driver;
    private MultipleWindowsPage multipleWindowsPage;

    public MultipleWindowsSteps () {
        Before(() -> {
            driver = Hooks.getDriver();
             multipleWindowsPage = new MultipleWindowsPage(driver);
        });

        Then("^I should be redirected to the Multiple Windows page$", (DataTable dataTable) -> {
            multipleWindowsPage.verifyMultipleWindowsPageText(dataTable.asMap(String.class, String.class));
        });

        Then("^I validate that a new window opens with url$", (DataTable dataTable) -> {
            multipleWindowsPage.switchToNewWindow();
            multipleWindowsPage.validateNewWindowURL(dataTable.asMap(String.class, String.class));

        });

        Then("^I validate text in new open window$", (DataTable datatable) -> {
            multipleWindowsPage.validateTextInNewOpenedWindow(datatable.asMap(String.class, String.class));
        });

        When("^I switch to (.*) window$", (String window) -> {
            if(window.equalsIgnoreCase("original")) {
                AppUtilities.switchToNewWindow(driver, 0);
            } else {
                String numericPortionOfString = window.replaceAll("//D", "");
                AppUtilities.switchToNewWindow(driver,Integer.parseInt(numericPortionOfString));
            }
        });

        When("^I click on (.*) link (.+) times$", (String linkText, String numOfClicks) -> {
            multipleWindowsPage.clickLinkTextMultipleTimes(linkText, Integer.parseInt(numOfClicks));
        });

        Then("^I validate the number of open windows$", () -> {
            multipleWindowsPage.validateNumberOfOpenWindows();
        });

        When("^I close current window$", () -> {
            AppUtilities.closeCurrentBrowserWindow(driver);
        });

        When("^I close remaining windows$", () -> {
            AppUtilities.closeAllBrowserWindows(driver);
        });
    }
}
