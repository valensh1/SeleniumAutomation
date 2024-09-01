package InternetHerokuApp.pageObjects;

import org.openqa.selenium.By;

public class ContextMenuPO {
    protected By contextMenuPageTitle = By.xpath("//*[@id='content']//h3");
    protected By contextMenuPageParagraphText = By.xpath("//*[@id='content']//p");
    protected By contextMenuPageHotSpot = By.id("hot-spot");
}
