package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.LoginPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginPO {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (this.driver == null) {
            System.err.println("WebDriver is null in LoginPage constructor");
        } else {
            System.out.println("LoginPage initialized with driver: " + (this.driver != null));
        }
    }

    public void inputUsername(String username) throws InterruptedException {
        driver.findElement(By.xpath(usernameInput)).sendKeys(username);
        }


    public void inputPassword(String password) throws InterruptedException {
        driver.findElement(By.xpath(passwordInput)).sendKeys(password);
    }

    public void clickLoginButton () throws InterruptedException {
        driver.findElement(By.xpath(loginButton)).click();
        Thread.sleep(3000);
    }

    }

