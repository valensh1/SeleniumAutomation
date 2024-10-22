package Mobile.AndroidNativeApplication.Costco.Pages;

import InternetHerokuApp.pages.AppUtilities;
import Mobile.AndroidNativeApplication.Costco.PageObjects.ShopPagePO;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ShopPage extends ShopPagePO {
    private AndroidDriver driver;

    public ShopPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectFromList(String listItem) {
        AppUtilities.scrollAndClickByText(driver, listItem);
    }

    public void addItemsToCart(int itemNumberOnPage) {
//    WebElement addButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id='addbutton-"+itemNumberOnPage+"']"));
//    addButton.click();
//        List<WebElement> addButtonsList = driver.findElements(addButtons);
//        int itemsNumber = addButtonsList.size();
//        System.out.println("This is the number of add items buttons "+itemsNumber);
        String addButtonToClick = "//android.widget.Button[@resource-id='addbutton-"+itemNumberOnPage+"']";
        AppUtilities.scrollAndClickByElement(driver, addButtonToClick);
    }
}
