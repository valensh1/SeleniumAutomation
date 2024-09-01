package stepDefinitions.InternetHerokuApp;

import InternetHerokuApp.pages.HoverPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

public class HoverSteps implements En {
    private WebDriver driver;
    private HoverPage hoverPage;

    public HoverSteps() {
        Before(() -> {
            driver = Hooks.getDriver();
            hoverPage = new HoverPage(driver);
        });

        Then("^I should be redirected to the Hovers page$", (DataTable dataTable) -> {
            hoverPage.verifyHoversPageText(dataTable.asMap(String.class, String.class));
        });

        When("^I hover over image (.*)$", (String imageNumber) -> {
            hoverPage.hoverImage(imageNumber);
        });

        Then("^I verify image (.+) text and profile link displays$", (String imageNumber) -> {
            hoverPage.verifyElementsUponHover(imageNumber);
        });

        When("^I click on View profile link of image (.+)$", (String imageNumber) -> {
            hoverPage.clickViewProfileLink(imageNumber);
        });

        Then("^I verify I am redirected to correct URL address of image (.+)$", (String imageNumber) -> {
            hoverPage.verifyURL(imageNumber);
        });
    }
}
