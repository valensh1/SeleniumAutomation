package stepDefinitions.Mobile.AndroidNativeApplication.Costco;

import Mobile.AndroidNativeApplication.Costco.Pages.WarehouseSearchPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java8.En;
import stepDefinitions.Hooks;

public class WarehouseLocationSteps implements En {
    private AndroidDriver driver;
    private WarehouseSearchPage warehouseSearchPage;

    public WarehouseLocationSteps() {
        Before(() -> {
            driver = Hooks.getAndroidDriver();
            warehouseSearchPage = new WarehouseSearchPage(driver);
        });


        Given("^I am on the Warehouses search page$", () -> {
            warehouseSearchPage.verifyWarehouseSearchPageLoaded();
        });

        When("^I enter city of (.+)$", (String city) -> {
            warehouseSearchPage.enterSearchCriteria(city);
        });

        Then("^I verify filtered city search result$", () -> {
            warehouseSearchPage.verifySearchResults();
        });

        When("^I tap on city from search results$", () -> {
            warehouseSearchPage.selectSearchResult();
        });

        When("^I find my warehouse from list$", () -> {
            warehouseSearchPage.searchForWarehouse();
        });

        When("^I tap on (.+) button$", (String buttonText) -> {
            warehouseSearchPage.clickWarehousePageButton(buttonText);
        });

        Then("^I verify my warehouse has been successfully set$", () -> {
            warehouseSearchPage.verifyWarehouseSet();
        });
    }
}

