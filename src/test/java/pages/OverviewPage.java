package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FINISH_BUTTON = By.id("finish");

    @Step("Нажатие на кнопку Finish")
    public CompletePage clickToFinish() {
        driver.findElement(FINISH_BUTTON).click();
        return new CompletePage(driver);
    }
}
