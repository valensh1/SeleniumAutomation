package Mobile.AndroidNativeApplication.Costco.Pages;

import InternetHerokuApp.pages.AppUtilities;
import Mobile.AndroidNativeApplication.Costco.PageObjects.ShopPagePO;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ShopPage extends ShopPagePO {
    private AndroidDriver driver;
    public String itemName;
    public String itemPrice;

    public ShopPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectFromList(String listItem) {
        AppUtilities.scrollAndClickByText(driver, listItem);
    }

    public void addItemsToCart(int itemNumberOnPage) {
        String itemToAddToCart = "//android.widget.Button[@resource-id='addbutton-"+itemNumberOnPage+"']";
        AppUtilities.scrollAndClickByElement(driver, itemToAddToCart);
        itemName = driver.findElement(By.xpath("//*[contains(@resource-id, 'AddToCartForm-"+itemNumberOnPage+"')]")).getText();
        itemPrice = driver.findElement(By.xpath("(//*[contains(@resource-id, 'price')])["+(itemNumberOnPage+1)+"]")).getText();
        System.out.println("This is the item name -> " + itemName + " and this is the item price " + itemPrice);
    }
}
