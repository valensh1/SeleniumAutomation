package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.DropdownPO;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DropdownPage extends DropdownPO {
    WebDriver driver;
    String optionSelected;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyDropdownPageLoaded(Map<String, String> sections) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        SoftAssertions softAssertions = new SoftAssertions();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(dropdownPageTitle)));
        Select dropdown = new Select(driver.findElement(dropdownMenu));
        for(Map.Entry<String, String> entry: sections.entrySet()) {
            switch(entry.getKey().toLowerCase()) {
                case "title" -> softAssertions.assertThat(driver.findElement(dropdownPageTitle).getText()).isEqualToIgnoringCase(entry.getValue());
                case "default menu option" -> softAssertions.assertThat(dropdown.getFirstSelectedOption().getText()).isEqualTo(entry.getValue());
            }
        }
        softAssertions.assertAll();
    }

    public void dropdownMenuSelectionByText(String optionText) {
        WebElement dropdown = driver.findElement(dropdownMenu);
        AppUtilities.dropdownMenuSelectionByText(driver, dropdown, optionText);
        optionSelected = optionText;
    }

    public void verifyDropdownSelection() {
      assertThat(driver.findElement(selectedDropdownItem).getText()).isEqualTo(optionSelected);
    }

    public void verifyDefaultDropdownStatus(Map<String, String> sections) {
        System.out.println("This is the default option ->" +sections.get("default menu option"));
        assertThat(sections.get("default menu option")).isEqualToIgnoringCase("Please select an option");
    }
}
