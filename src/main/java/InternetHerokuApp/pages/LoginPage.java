package InternetHerokuApp.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() throws InterruptedException {
        if (driver == null) {
            System.out.println("WebDriver is null in LoginPage!");
            return;
        }
        driver.get("https://the-internet.herokuapp.com/login");
        System.out.println("This line of code was hit");
        Thread.sleep(2000);
    }
}
