package InternetHerokuApp.pages;

import InternetHerokuApp.pageObjects.ContextMenuPO;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContextMenuPage extends ContextMenuPO {
    private WebDriver driver;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyContextMenuPageText(Map<String, String> sections) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        SoftAssertions softAssertions = new SoftAssertions();

        for (Map.Entry<String, String> entry : sections.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "title" -> {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(contextMenuPageTitle));
                    softAssertions.assertThat(driver.findElement(contextMenuPageTitle).getText()).isEqualToIgnoringCase(entry.getValue());
                }
                case "paragraph 1" -> {
                    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(contextMenuPageParagraphText)));
                    softAssertions.assertThat(driver.findElements(contextMenuPageParagraphText).get(0).getText()).isEqualTo(entry.getValue());
                }
                case "paragraph 2" -> {
                    wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(contextMenuPageParagraphText)));
                    softAssertions.assertThat(driver.findElements(contextMenuPageParagraphText).get(1).getText()).isEqualTo(entry.getValue());
                }
            }
        }
        softAssertions.assertAll();
    }

    public void verifyAlertMessageText(Map<String, String> sections) {
        String alertText = driver.switchTo().alert().getText();
        for (Map.Entry<String, String> entry : sections.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("alert message")) {
                assertThat(alertText).isEqualTo(entry.getValue());
            }
        }
    }

    public void rightClickHotSpot() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contextMenuPageHotSpot)).perform();
    }
}
