package stepDefinitions.InternetHerokuApp;
import InternetHerokuApp.pages.LoginPage;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;
import static stepDefinitions.Hooks.driver;

public class LoginSteps implements En {
    private LoginPage loginPage;

    public LoginSteps () {


        When("^I enter valid username (.+)$", (String userName) -> {
        loginPage = new LoginPage(driver);
            loginPage.inputUsername(userName);
        });

        When("^I enter a valid password (.+)$", (String password) -> {
            loginPage.inputPassword(password);
        });

        When("^I click (.+) button$", (String password) -> {
            loginPage.clickLoginButton();
        });

        Then("^I validate successful login message$", () -> {
            String text = driver.findElement(loginPage.loginMessage).getText().trim();
            assertThat(text).contains("You logged into a secure area!");
        });
    }
}
