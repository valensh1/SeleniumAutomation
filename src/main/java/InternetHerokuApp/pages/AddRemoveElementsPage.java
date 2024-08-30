package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.AddRemoveElementsPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void clickButtonNumTimes(String button, int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            AppUtilities.clickElementByText(driver, button);
                waitUntilElementVisible(i + 1);
        }
    }

    public void waitUntilElementVisible(int count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButtonCollection));
    }

    public void validateNumberOfButtonsDisplayed(int count) {
        int buttonCount = driver.findElements(deleteButtonCollection).size();
        System.out.println("The number of buttons that should be displayed is " + buttonCount + " and that compares to the actual of " + count);
        assertThat(buttonCount).isEqualTo(count);
    }
}
