package stepDefinitions.Mobile.AndroidNativeApplication.Costco;

import Mobile.AndroidNativeApplication.Costco.Pages.ShopPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java8.En;
import lombok.Getter;
import lombok.Setter;
import stepDefinitions.Hooks;

public class ShopPageSteps implements En {
    @Getter
    @Setter
    private AndroidDriver driver;

    @Getter
    @Setter
    private ShopPage shopPage;

    public ShopPageSteps() {
        Before(() -> {
            setDriver(Hooks.getAndroidDriver());
            setShopPage(new ShopPage(driver));
        });

        When("^I tap on (.+) department$", (String department) -> {
            shopPage.selectFromList(department);
        });

        When("^I tap on (.+) from categories list$", (String category) -> {
            shopPage.selectFromList(category);
        });

        When("^I tap on (.+) from subcategories list$", (String subCategory) -> {
            shopPage.selectFromList(subCategory);
        });

        When("^I tap (.+) button on the Shop page$", (String buttonText) -> {
            shopPage.addItemsToCart(1);
            Thread.sleep(5000);
        });




    }
}
