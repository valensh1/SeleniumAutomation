package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pageObjects.LoginPO;
import InternetHerokuApp.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class LoginSteps extends LoginPO implements En {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        // Use a Before hook to ensure driver and pages are initialized before any step runs
        Before(() -> {
            this.driver = Hooks.getDriver();
            loginPage = new LoginPage(driver);
        });

        Then("^I should be redirected to the Login page$", () -> {
            loginPage.verifyLoginPageLoaded();
        });

        When("^I enter username (.+)$", (String userName) -> {
            loginPage.inputUsername(userName);
        });

        When("^I enter password (.+)$", (String password) -> {
            loginPage.inputPassword(password);
        });

        Then("^I verify (valid|invalid)? ?(login|logout) message$", (String validity, String action, DataTable data) -> {
            if (validity == null || validity.isEmpty()) {
                validity = "";
            }
            loginPage.verifyLoginPageMessages(validity, action, data.asMap(String.class, String.class));
        });
    }
}
