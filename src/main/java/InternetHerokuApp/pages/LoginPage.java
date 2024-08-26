package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.LoginPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginPage extends LoginPO {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username)  {
        driver.findElement(By.xpath(usernameInput)).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(By.xpath(passwordInput)).sendKeys(password);
    }

    public void verifyLoginPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageHeader));
    }

    public void verifyLoginPageMessages(String validity, String action, Map<String, String> data) {
        String messageToAssert = driver.findElement(loginMessage).getText().replace("×", "").trim();
        String combinedCondition = validity + " " + action;
        switch (combinedCondition.trim()) {
            case "valid login":
                assertThat(messageToAssert).isEqualTo(data.get("valid message"));
                break;
            case "invalid login":
                assertThat(messageToAssert).isEqualTo(data.get("invalid message"));
                break;
            case "logout":
                assertThat((messageToAssert)).isEqualTo(data.get("logout message"));
                break;
            default:
                throw new IllegalArgumentException("Unexpected action: " + action);
        }
    }

}

