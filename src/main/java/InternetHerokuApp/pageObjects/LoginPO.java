package InternetHerokuApp.pageObjects;


import org.openqa.selenium.By;

public class LoginPO {
   public final String usernameInput = "//*[@id='username']";
   public final String passwordInput = "//*[@id='password']";
   public final String loginButton = "//button[@type='submit']";
//   public final String loginMessage = "flash success";
   public final By loginMessage = By.id("flash");
   public final By loginPageHeader = By.xpath("//*[contains(text(), 'Login Page')]");
}
