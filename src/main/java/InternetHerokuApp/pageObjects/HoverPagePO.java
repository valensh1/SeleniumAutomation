package InternetHerokuApp.pageObjects;

import org.openqa.selenium.By;

public class HoverPagePO {
    protected By hoversPageTitle = By.xpath("//*[@id='content']//h3");
    protected By hoversPageText = By.xpath("//*[@id='content']//p");
    protected By hoversPageImages = By.xpath("//*[@class='figure']//img");
    protected By hoversPageImageCaptionsText = By.xpath("//*[@class='figcaption']//h5");
    protected By hoversPageImageLink = By.xpath("//*[@class='figcaption']//a");
}
