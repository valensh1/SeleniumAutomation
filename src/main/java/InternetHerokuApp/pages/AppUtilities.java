package InternetHerokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AppUtilities {

    public static void navigateToPage(WebDriver driver, String page) {
        switch (page.toLowerCase()) {
            case "login" -> driver.get("https://the-internet.herokuapp.com/login");
            case "checkboxes" -> driver.get("https://the-internet.herokuapp.com/checkboxes");
            case "add/remove elements" -> driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            case "hovers" -> driver.get("https://the-internet.herokuapp.com/hovers");
            case "context menu" -> driver.get("https://the-internet.herokuapp.com/context_menu");
        }
    }

    public static void clickElementByText(WebDriver driver, String text) {
        if (text.equalsIgnoreCase("back")) driver.navigate().back();
        String xpathExpression = String.format("//*[normalize-space(text())='%s']", text);
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public static void hoverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void rightClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void clickOKAlertMessage(WebDriver driver) {
        driver.switchTo().alert().accept();
    }
}
