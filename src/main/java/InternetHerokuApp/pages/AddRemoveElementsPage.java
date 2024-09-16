package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.AddRemoveElementsPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddRemoveElementsPage extends AddRemoveElementsPO {
    private WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAddRemoveElementsPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addRemoveElementsPageTitle)));
    }

    public void clickButtonNumTimes(String button, int clickCount, int buttonCount)  {
        while(clickCount > 0) {
            AppUtilities.clickElementByText(driver, button);
                waitUntilElementVisible(clickCount, buttonCount, button);
                clickCount--;
        }
    }

    public void waitUntilElementVisible(int clickCount, int buttonCount, String button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        if (clickCount == 1 && buttonCount == 0 && button.equalsIgnoreCase("delete")) {
            wait.until(ExpectedConditions.numberOfElementsToBe(deleteButtonCollection, 0));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButtonCollection));
        }
    }

    public void validateNumberOfButtonsDisplayed(int count) {
        int buttonCount = driver.findElements(deleteButtonCollection).size();
        assertThat(buttonCount).isEqualTo(count);
    }
}
