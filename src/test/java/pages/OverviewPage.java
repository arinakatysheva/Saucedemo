package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class OverviewPage {
    WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FINISH_BUTTON = By.id("finish");

    @Step("Нажатие на кнопку Finish")
    public CompletePage clickToFinish() {
        log.info("Нажатие на кнопку Finish");
        driver.findElement(FINISH_BUTTON).click();
        return new CompletePage(driver);
    }
}
