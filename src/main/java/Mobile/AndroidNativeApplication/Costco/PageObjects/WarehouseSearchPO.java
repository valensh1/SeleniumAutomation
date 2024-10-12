package Mobile.AndroidNativeApplication.Costco.PageObjects;

import org.openqa.selenium.By;

public class WarehouseSearchPO {
    protected By warehouseSearchBar = By.xpath("//android.widget.EditText");
    protected By warehouseSearchBarPlaceholderText = By.xpath("//*[@text='City/State or Zip Code']");
    protected By warehousePageButtonElement = By.xpath("//android.widget.Button");
}
