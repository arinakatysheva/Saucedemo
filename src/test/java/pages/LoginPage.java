package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By USER_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    @Step("Открытие страницы логина") //указываем, что делает метод
    public LoginPage open() {
        driver.get("https://www.saucedemo.com"); //метод открытия страницы
        return this; //вернуть страницу авторизации
    }

    @Step("Вход в систему с данными пользователя: логин - {user} и пароль {password}")
    public ProductsPage login(String user, String password) { //указываем переменные, которые хотим использовать внутри метода
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Вход в систему с данными пользователя: логин - {user} и пароль {password}")
    public LoginPage loginForNegativeData(String user, String password) { //указываем переменные, которые хотим использовать внутри метода
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText(); //возвращаем строку ошибки
    }
}
