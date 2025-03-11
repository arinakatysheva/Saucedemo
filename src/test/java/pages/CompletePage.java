package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
    WebDriver driver;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By COMPLETE_MESSAGE = By.xpath("//h2");

    public String getCompleteMessage() {
        return driver.findElement(COMPLETE_MESSAGE).getText();
    }
}
