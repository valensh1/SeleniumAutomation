package InternetHerokuApp.pageObjects;

import org.openqa.selenium.By;

public class AddRemoveElementsPO {

    public AddRemoveElementsPO() {
    }

    protected By addRemoveElementsPageTitle = By.cssSelector("#content > h3");
    protected By deleteButtonCollection = By.xpath("//*[@id='elements']/button");
}
