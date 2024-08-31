package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.CheckboxesPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckboxesPage extends CheckboxesPO {
    private WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getCheckboxElement(String checkboxNumber) {
        return driver.findElements(checkboxes).get(Integer.parseInt(checkboxNumber) - 1);
    }

    public void verifyCheckboxesPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxesTitle));
    }

    public void isChecked(String checkboxNumber, String status) {
        WebElement checkboxElement = getCheckboxElement(checkboxNumber);
        if(status.equalsIgnoreCase("unchecked")) {
            assertThat(checkboxElement.isSelected()).isFalse();
        } else {
            assertThat(checkboxElement.isSelected()).isTrue();
        }
    }

    public void clickCheckbox(String checkboxNumber) {
        getCheckboxElement(checkboxNumber).click();
    }
}
