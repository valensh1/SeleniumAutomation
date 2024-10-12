package stepDefinitions.Mobile.AndroidNativeApplication.Costco;

import Mobile.AndroidNativeApplication.Costco.Pages.WarehousePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java8.En;
import stepDefinitions.Hooks;


public class WarehousePageSteps implements En {
    private AndroidDriver driver;
    private WarehousePage warehousePage;


    public WarehousePageSteps() {
        Before(() -> {
            driver = Hooks.getAndroidDriver();
            warehousePage = new WarehousePage(driver);
        });

        Then("^I verify my set warehouse displays on Warehouse page$", () -> {
            warehousePage.verifySetWarehouse();
        });
    }
}
