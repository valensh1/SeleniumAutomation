package InternetHerokuApp.pageObjects;

import org.openqa.selenium.By;

public class MultipleWindowsPO {
    protected By multipleWindowsPageTitle = By.xpath("//*[@id='content']//h3");
    protected By getMultipleWindowsPageLink = By.linkText("Click here");

//    New window that opens up
    protected By newOpenedWindowTitle = By.xpath("//*[@class='example']/h3");
}
