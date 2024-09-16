package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.MultipleWindowsPO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultipleWindowsPage extends MultipleWindowsPO {
    private WebDriver driver;
    private int clicks;

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyMultipleWindowsPageText(Map<String, String> sections) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        for (Map.Entry<String, String> entry : sections.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "title" -> {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(multipleWindowsPageTitle));
                    assertThat(driver.findElement(multipleWindowsPageTitle).getText()).isEqualToIgnoringCase("Opening a new window");
                }
            }
        }
    }

    public void validateTextInNewOpenedWindow(Map<String, String> sections) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        for (Map.Entry<String, String> entry : sections.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "title" -> {
                    assertThat(entry.getValue()).isEqualToIgnoringCase("New Window");
                }
            }
        }
    }

    public void switchToNewWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
    }

    public void validateNewWindowURL(Map<String, String> sections) {
        String newWindowURL = driver.getCurrentUrl();

        for (Map.Entry<String, String> entry : sections.entrySet()) {
            assertThat(newWindowURL).contains(entry.getValue());
        }
    }

    public void validateNumberOfOpenWindows() {
        Set<String> window = driver.getWindowHandles();
        assertThat(window.size()).isEqualTo(clicks + 1);
    }

    public void clickLinkTextMultipleTimes(String link, int numOfClicks) {
        clicks = numOfClicks;
        for (int i = 0; i < numOfClicks; i++) {
            AppUtilities.pressKey(driver, Keys.CONTROL);
            AppUtilities.clickElementByText(driver, link);
            AppUtilities.releaseKey(driver, Keys.CONTROL);
        }
    }


}
