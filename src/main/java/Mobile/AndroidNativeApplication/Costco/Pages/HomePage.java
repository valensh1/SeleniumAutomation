package Mobile.AndroidNativeApplication.Costco.Pages;

import Mobile.AndroidNativeApplication.Costco.PageObjects.HomePagePO;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePage extends HomePagePO {
    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void verifySetWarehouse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String searchText = WarehouseSearchPage.searchText;
        WebElement elementContainingWarehouseName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, '"+searchText+"')]")));
        assertThat(elementContainingWarehouseName.getAttribute("content-desc")).contains(searchText);
    };
}
