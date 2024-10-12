package Mobile.AndroidNativeApplication.Costco.Pages;

import InternetHerokuApp.pages.AppUtilities;
import Mobile.AndroidNativeApplication.Costco.PageObjects.WarehouseSearchPO;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WarehouseSearchPage extends WarehouseSearchPO {
    private AndroidDriver driver;
    public static String searchText;
    private WebElement searchResult;

    public WarehouseSearchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void verifyWarehouseSearchPageLoaded() {
        assertThat(driver.findElement(warehouseSearchBar).isDisplayed()).isTrue();
        assertThat(driver.findElement(warehouseSearchBarPlaceholderText).getAttribute("text")).isEqualToIgnoringCase("City/State or Zip Code");
    }

    public void enterSearchCriteria(String text) {
        AppUtilities.enterText(driver.findElement(warehouseSearchBar), text);
        searchText = text;
        System.out.println("Setting search text as -> "+searchText);
    }

    public void verifySearchResults() {
        searchResult = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + searchText + "')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       assertThat(searchResult.getText()).containsIgnoringCase(searchText);
    }

    public void selectSearchResult() {
        AppUtilities.clickElement(driver, searchResult);
    }

    public void searchForWarehouse()  {
        AppUtilities.scrollAndClick(driver, searchText, 1); // If searching for 1st instance of something put 0, 2nd instance of text then put 1, etc.
    }

    public void clickWarehousePageButton(String text) {
        switch(text.toLowerCase()) {
            case "allow", "ok", "yes" -> {
                driver.findElements(warehousePageButtonElement).get(0).click();
            }
            case "don't allow", "cancel", "no" -> {
                driver.findElements(warehousePageButtonElement).get(1).click();
            }
            default -> AppUtilities.clickElement(driver, driver.findElement(warehousePageButtonElement));
        }
    }

    public void verifyWarehouseSet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementContainingWarehouseName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '"+searchText+"')]")));
        assertThat(elementContainingWarehouseName.getAttribute("content-desc")).contains(searchText);
    }
}
