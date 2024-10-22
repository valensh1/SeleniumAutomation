package InternetHerokuApp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AppUtilities {

    public static void navigateToPage(WebDriver driver, String page) {
        switch (page.toLowerCase()) {
            case "login" -> driver.get("https://the-internet.herokuapp.com/login");
            case "checkboxes" -> driver.get("https://the-internet.herokuapp.com/checkboxes");
            case "add/remove elements" -> driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            case "hovers" -> driver.get("https://the-internet.herokuapp.com/hovers");
            case "dropdown" -> driver.get("https://the-internet.herokuapp.com/dropdown");
            case "multiple windows" -> driver.get("https://the-internet.herokuapp.com/windows");
        }
    }

    public static void clickElementByText(WebDriver driver, String text) {
        String xpathExpression;
        if (text.equalsIgnoreCase("back")) driver.navigate().back();
        if (driver instanceof AndroidDriver) {
            try {
                xpathExpression = String.format("//android.widget.TextView[@text='%s']", text);
                driver.findElement(By.xpath(xpathExpression)).click();
            } catch (NoSuchElementException error) {
                System.out.println("Element was not found; Scrolling to find element");
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text + "\").instance(1))"
                )).click();
            }
        } else {
            xpathExpression = String.format("//*[normalize-space(text())='%s']", text);
            driver.findElement(By.xpath(xpathExpression)).click();
        }
    }

    public static void clickElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void scrollAndClickByElement(AndroidDriver driver, By element) {
        String scrollableElement = "new UiScrollable(new UiSelector().scrollable(true))";
        int maxAttempts = 10; // Set a limit to avoid infinite scrolling
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                // Try to find the element
                WebElement webElement = driver.findElement(element);
                if (webElement.isDisplayed()) {
                    webElement.click(); // Click the element if found and displayed
                    System.out.println("Clicked on the element.");
                    return; // Exit the method after clicking
                }
            } catch (NoSuchElementException e) {
                // If the element isn't found, continue scrolling
                System.out.println("Element not found: Scrolling forward");
            } catch (WebDriverException e) {
                System.err.println("WebDriver error: " + e.getMessage());
                break; // Exit the loop if there's a WebDriver error
            }

            // Scroll forward in small increments to avoid overshooting
            driver.findElement(AppiumBy.androidUIAutomator(
                    scrollableElement + ".scrollForward()"
            ));

            attempts++;
        }

        System.out.println("Element with locator '" + element + "' not found after scrolling.");
    }

    public static void scrollAndClickByElement(AndroidDriver driver, String element) {
        System.out.println("This is the element I am looking to click: " + element);
        int maxAttempts = 10; // Set a limit to avoid infinite scrolling
        int attempts = 0;

        // Define the scrollable element selector
        String scrollableElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0))";

        while (attempts < maxAttempts) {
            try {
                // Try to find the element before scrolling
                WebElement webElement = driver.findElement(By.xpath(element));
                if (webElement.isDisplayed()) {
                    webElement.click(); // Click the element if found and displayed
                    System.out.println("Clicked on the element with resource-id: " + element);
                    return; // Exit the method after clicking
                }
            } catch (NoSuchElementException e) {
                // If the element isn't found, continue scrolling
                System.out.println("Element not found: Scrolling forward");
            } catch (WebDriverException e) {
                System.err.println("WebDriver error: " + e.getMessage());
                break; // Exit the loop if there's a WebDriver error
            }

            // Scroll forward to the next view
            driver.findElement(AppiumBy.androidUIAutomator(
                    scrollableElement + ".scrollForward()"
            ));

            attempts++;
        }

        System.out.println("Element with resource-id '" + element + "' not found after " + maxAttempts + " scroll attempts.");
    }

    public static void scrollAndClickByText(AndroidDriver driver, String text) {
        String scrollableElement = "new UiScrollable(new UiSelector().scrollable(true))";
        int maxAttempts = 10; // Set a limit to avoid infinite scrolling
        int attempts = 0;

        // Use regex to ignore case by matching with (?i) at the start of the pattern
        String regexText = "(?i)" + text; // This makes the regex case-insensitive

        while (attempts < maxAttempts) {
            try {
                // Try to find the element by case-insensitive text using regex
                WebElement webElement = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().textMatches(\"" + regexText + "\")"
                ));

                if (webElement.isDisplayed()) {
                    webElement.click(); // Click the element if found and displayed
                    System.out.println("Clicked on the element with text: " + text);
                    return; // Exit the method after clicking
                }
            } catch (NoSuchElementException e) {
                // If the element isn't found, continue scrolling
                System.out.println("Element with text '" + text + "' not found: Scrolling forward");
            } catch (WebDriverException e) {
                System.err.println("WebDriver error: " + e.getMessage());
                break; // Exit the loop if there's a WebDriver error
            }

            // Scroll forward in small increments to avoid overshooting
            driver.findElement(AppiumBy.androidUIAutomator(
                    scrollableElement + ".scrollForward()"
            ));

            attempts++;
        }

        System.out.println("Element with text '" + text + "' not found after scrolling.");
    }

    public static void scrollAndClickByText(AndroidDriver driver, String text, int instance) {
        String scrollableElement = "new UiScrollable(new UiSelector().scrollable(true))";
        int maxAttempts = 10; // Set a limit to avoid infinite scrolling
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                // Try to find the element by text and instance
                WebElement webElement = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + text + "\").instance(" + instance + ")"
                ));

                if (webElement.isDisplayed()) {
                    webElement.click(); // Click the element if found and displayed
                    System.out.println("Clicked on the element with text: " + text + " and instance: " + instance);
                    return; // Exit the method after clicking
                }
            } catch (NoSuchElementException e) {
                // If the element isn't found, continue scrolling
                System.out.println("Element with text '" + text + "' and instance '" + instance + "' not found: Scrolling forward");
            } catch (WebDriverException e) {
                System.err.println("WebDriver error: " + e.getMessage());
                break; // Exit the loop if there's a WebDriver error
            }

            // Scroll forward in small increments to avoid overshooting
            driver.findElement(AppiumBy.androidUIAutomator(
                    scrollableElement + ".scrollForward()"
            ));

            attempts++;
        }

        System.out.println("Element with text '" + text + "' and instance '" + instance + "' not found after scrolling.");
    }

    public static void pressKey(WebDriver driver, CharSequence key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key);
    }

    public static void releaseKey(WebDriver driver, CharSequence key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key);
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

    public static void switchToNewWindow(WebDriver driver, int windowNumber) {
        List<String> windows = driver.getWindowHandles().stream().toList();
        String windowToSwitchTo = windows.get(windowNumber);
        driver.switchTo().window(windowToSwitchTo);
    }

    public static void closeCurrentBrowserWindow(WebDriver driver) {
        driver.close();
    }

    public static void closeAllBrowserWindows(WebDriver driver) {
        driver.quit();
    }

    public static void enterText(WebElement element, String text) {
        System.out.println("This is the element " + element);
        System.out.println("This is the text " + text);
        element.sendKeys(text);
    }
}

