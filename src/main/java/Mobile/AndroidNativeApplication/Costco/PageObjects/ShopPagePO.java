package Mobile.AndroidNativeApplication.Costco.PageObjects;

import org.openqa.selenium.By;

public class ShopPagePO {
    protected By toysDepartment = By.xpath("//*[@text='Toys']");
    protected By holidayAndSeasonalDepartment = By.xpath("//*[@text='Holiday & Seasonal']");
    protected By addButtons = By.xpath("//android.widget.Button[@text='Add']");
}
