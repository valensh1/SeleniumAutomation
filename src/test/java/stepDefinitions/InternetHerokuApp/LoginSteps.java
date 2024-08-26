package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pageObjects.LoginPO;
import InternetHerokuApp.pages.AppUtilities;
import InternetHerokuApp.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class LoginSteps extends LoginPO implements En {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {

        Then("^I should be redirected to the Login page$", () -> {
            driver = Hooks.getDriver();
            loginPage = new LoginPage(driver);
            loginPage.verifyLoginPageLoaded();
        });

        When("^I enter username (.+)$", (String userName) -> {
            loginPage.inputUsername(userName);
        });

        When("^I enter password (.+)$", (String password) -> {
            loginPage.inputPassword(password);
        });

        When("^I click (.+) button$", (String button) -> {
            AppUtilities.clickElementByText(driver, button);
        });

        Then("^I verify (valid|invalid)? ?(login|logout) message$", (String validity, String action, DataTable data) -> {
            if(validity == null || validity.isEmpty()) {
                validity = "";
            }
            loginPage.verifyLoginPageMessages(validity, action, data.asMap(String.class, String.class));
        });


    }
}
