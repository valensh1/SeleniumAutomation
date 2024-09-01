package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.HoverPagePO;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HoverPage extends HoverPagePO {
    private WebDriver driver;

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHoversPageText(Map<String, String> sections) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        SoftAssertions softAssertions = new SoftAssertions();

        for (Map.Entry<String, String> entry : sections.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "title" -> {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(hoversPageTitle));
                    softAssertions.assertThat(driver.findElement(hoversPageTitle).getText()).isEqualToIgnoringCase(entry.getValue());
                }
                case "hover page text" -> {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(hoversPageText));
                    softAssertions.assertThat(driver.findElement(hoversPageText).getText()).isEqualToIgnoringCase(entry.getValue());
                }
            }
        }
        softAssertions.assertAll();
    }

    public void hoverImage(String imageNumber) {
        WebElement hoverableImage = driver.findElements(hoversPageImages).get(Integer.parseInt(imageNumber) - 1);
        AppUtilities.hoverElement(driver, hoverableImage);
    }

    public void verifyElementsUponHover(String imageNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = driver.findElements(hoversPageImageCaptionsText).get(Integer.parseInt(imageNumber) - 1);
        WebElement link = driver.findElements(hoversPageImageLink).get(Integer.parseInt(imageNumber) - 1);
        wait.until(ExpectedConditions.visibilityOf(element));
        assertThat(element.getText().contains("name: user"+Integer.parseInt(imageNumber))).isTrue();
        assertThat(link.getText()).isEqualToIgnoringCase("View profile");
    }

    public void clickViewProfileLink(String imageNumber) {
        driver.findElements(hoversPageImageLink).get(Integer.parseInt(imageNumber) - 1).click();
    }

    public void verifyURL(String imageNumber) {
        assertThat(driver.getCurrentUrl()).contains("/users/"+imageNumber);
    }
}
