package Mobile.AndroidNativeApplication.Costco.Pages;

import Mobile.AndroidNativeApplication.Costco.PageObjects.NavBarPO;
import io.appium.java_client.android.AndroidDriver;

public class Navigations extends NavBarPO {
    private AndroidDriver driver;

    public Navigations(AndroidDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(AndroidDriver driver, String page) {
        switch (page.toLowerCase()) {
            case "explore" -> {
                driver.findElement(exploreTab).click();
            }
            case "shop" -> {
                driver.findElement(shopTab).click();
            }
            case "account" -> {
                driver.findElement(accountTab).click();
            }
            case "warehouse" -> {
                driver.findElement(warehouseTab).click();
            }
            case "cart" -> {
                driver.findElement(cartTab).click();
            }
        }
    }
}
