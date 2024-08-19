package InternetHerokuApp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AppUtils {
    private final WebDriver driver;
    private final String page;

    public AppUtils (WebDriver driver, String page) {
        this.driver = driver;
        this.page = page.toLowerCase();
    }
        public void navigateToPage() throws InterruptedException {
            switch(page) {
                case "login":
                    System.out.println("This is the page "+page);
                    if(driver != null) System.out.println("Driver is NOT null");
                    driver.get("https://the-internet.herokuapp.com/login");
                    LoginPage login = new LoginPage(driver);
                    waitForElement((login.loginPageHeader));
                    break;
                case "checkboxes":
                    System.out.println("This is the page "+page);
                    driver.get("https://the-internet.herokuapp.com/checkboxes");
                    break;
            }
        }

        public void waitForElement (By element) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
    }


