package Mobile.AndroidNativeApplication.Costco.PageObjects;

import org.openqa.selenium.By;

public class NavBarPO {
    protected By exploreTab = By.xpath("//android.widget.TextView[@text='Explore']");
    protected By shopTab = By.xpath("//android.widget.TextView[@text='Shop']");
    protected By accountTab = By.xpath("//android.widget.TextView[@text='Account']");
    protected By warehouseTab = By.xpath("//android.widget.TextView[@text='Warehouse']");
    protected By cartTab = By.xpath("//android.widget.TextView[@text='Cart']");
}
