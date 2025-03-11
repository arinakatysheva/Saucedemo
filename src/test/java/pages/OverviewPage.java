package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FINISH_BUTTON = By.id("finish");

    public void clickToFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
