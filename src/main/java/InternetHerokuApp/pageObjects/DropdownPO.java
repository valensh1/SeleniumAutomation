package InternetHerokuApp.pageObjects;

import org.openqa.selenium.By;

public class DropdownPO {
    protected By dropdownPageTitle = By.xpath("//*[@id='content']//h3");
    protected By dropdownMenu = By.id("dropdown");
    protected By selectedDropdownItem = By.xpath("//*[@id='dropdown']//option[@selected='selected']");
}
