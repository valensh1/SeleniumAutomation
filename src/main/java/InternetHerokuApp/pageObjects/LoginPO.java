package InternetHerokuApp.pageObjects;


import org.openqa.selenium.By;

public class LoginPO {
   protected String usernameInput = "//*[@id='username']";
   protected String passwordInput = "//*[@id='password']";
   protected By loginMessage = By.xpath("//*[@id='flash']");
   public By loginPageHeader = By.xpath("//*[contains(text(), 'Login Page')]");
}
