package InternetHerokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppUtilities {

    public static void navigateToPage(WebDriver driver, String page) {
        switch (page.toLowerCase()) {
            case "login":
                driver.get("https://the-internet.herokuapp.com/login");
                break;
            case "checkboxes":
                driver.get("https://the-internet.herokuapp.com/checkboxes");
                break;
            case "add/remove elements":
                driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
                break;
        }
    }

    public static void clickElementByText(WebDriver driver, String text) {
        String xpathExpression = String.format("//*[normalize-space(text())='%s']", text);
        driver.findElement(By.xpath(xpathExpression)).click();
    }
}
