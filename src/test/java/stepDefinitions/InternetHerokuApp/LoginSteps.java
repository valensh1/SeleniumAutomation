package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.LoginPage;
import io.cucumber.java8.En;
import stepDefinitions.Hooks;

public class LoginSteps implements En {

    private LoginPage loginPage;

    public LoginSteps() {

        Given("I am on login page", () -> {
            loginPage = new LoginPage(Hooks.getDriver());
            loginPage.navigateToLoginPage();
        });

        Given("this is a test", () -> {
            System.out.println("hello dude bro dude!");
        });
    }
}
