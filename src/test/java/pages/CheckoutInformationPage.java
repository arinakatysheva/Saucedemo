package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    WebDriver driver;

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By ZIP_CODE_FIELD = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");

    @Step("Заполнение формы данными: имя - {firstName}, фамилия - {lastName}, индекс - {zipCode}")
    public CheckoutInformationPage fillingForm(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(ZIP_CODE_FIELD).sendKeys(zipCode);
        return this;
    }

    @Step("Нажатие на кнопку Continue")
    public OverviewPage clickToContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new OverviewPage(driver);
    }
}
