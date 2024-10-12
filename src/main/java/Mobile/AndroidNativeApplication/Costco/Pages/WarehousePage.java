package Mobile.AndroidNativeApplication.Costco.Pages;

import Mobile.AndroidNativeApplication.Costco.PageObjects.WarehousePagePO;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WarehousePage extends WarehousePagePO {
    private AndroidDriver driver;

    public WarehousePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void verifySetWarehouse() {
        WarehouseSearchPage warehouseSearchPage = new WarehouseSearchPage(driver);
        String searchText = warehouseSearchPage.searchText;
        System.out.println("This is the search text I am looking for on Warehouse page -> " +searchText );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement warehouseName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '" + searchText + "')]")));
        assertThat(warehouseName.getText()).contains(searchText);
    }
}
