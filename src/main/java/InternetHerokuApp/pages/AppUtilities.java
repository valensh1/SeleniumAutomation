package InternetHerokuApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AppUtilities {

    public static void navigateToPage(WebDriver driver, String page) {
        switch (page.toLowerCase()) {
            case "login" ->
                driver.get("https://the-internet.herokuapp.com/login");
            case "checkboxes" ->
                driver.get("https://the-internet.herokuapp.com/checkboxes");
            case "add/remove elements" ->
                driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            case "hovers" ->
                    driver.get("https://the-internet.herokuapp.com/hovers");
            case "dropdown" ->
                    driver.get("https://the-internet.herokuapp.com/dropdown");
        }
    }

    public static void clickElementByText(WebDriver driver, String text) {
        if(text.equalsIgnoreCase("back")) driver.navigate().back();
        String xpathExpression = String.format("//*[normalize-space(text())='%s']", text);
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public static void hoverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void dropdownMenuSelectionByText(WebDriver driver, WebElement dropdownElement, String optionText) {
        Select dropdownMenu = new Select(dropdownElement);
        dropdownMenu.selectByVisibleText(optionText);
    }

    public static void dropdownMenuSelectionByText(WebDriver driver, WebElement dropdownElement, int optionNumber) {
        Select dropdownMenu = new Select(dropdownElement);
        dropdownMenu.selectByIndex(optionNumber);
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
}
