package InternetHerokuApp.pageObjects;

import org.openqa.selenium.By;

public class CheckboxesPO {
    protected By checkboxesTitle = By.xpath("//*[@id='content']//h3");
    protected By checkboxes = By.xpath("//*[@id='checkboxes']/input[@type='checkbox']");
}
