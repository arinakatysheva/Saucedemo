package tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    /*
    Негативный тест:
    1. Открыть страницу https://www.saucedemo.com
    2. Ввести в поле username значение "standard_user"
    3. Ввести в поле password "(пробел)"
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void checkNegativeLoginDesigned() { //использование паттерна Page Object
        loginPage.open()
                .loginForNegativeData("standard_user", " ");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test // аннотация
    public void checkNegativeLogin() {

        driver.get("https://www.saucedemo.com"); //получить страницу

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //ввести логин (локатор id из xtml-файла)
        driver.findElement(By.id("password")).sendKeys(" "); //ввести пароль
        driver.findElement(By.id("login-button")).click(); //нажать кнопку "Login"

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText(); //вывести сообщение об ошибке
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service"); //сравнить между собой два значения
    }

    /*
    Позитивный тест:
    1. Открыть страницу https://www.saucedemo.com
    2. Ввести в поле username значение standard_user
    3. Ввести в поле password пробел
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Password is required
     */

    @Test
    public void checkPositiveLoginDesigned() {
        loginPage.open()
                .login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }

    @Test
    public void checkPositiveLogin() {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean titleIsVisible = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed(); //найти уникальный элемент "Products" на странице, "true" - если видно
        assertTrue(titleIsVisible, "Products");
    }

    /*
    Домашнее задание - тест 1
    1.Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение "(пробел) Arina"
    3. Ввести в поле password значение "Katysheva"
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
      Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void checkNegativeLoginWithIncorrectLoginAndPassword() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(" Arina");
        driver.findElement(By.id("password")).sendKeys("Katysheva");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    /*
    Домашнее задание - тест 2
        1.Открыть страницу https://www.saucedemo.com/
        2. Ввести в поле username значение "standard_user"
        3. Ввести в поле password значение "Katysheva"
        4. Нажать кнопку Login
        5. Проверить, что мы видим сообщение об ошибке с текстом
          Epic sadface: Username and password do not match any user in this service
         */

    @Test
    public void checkNegativeLoginWithIncorrectPassword() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("Katysheva");
        driver.findElement(By.id("login-button")).click();

        boolean titleIsVisible = driver.findElement(By.cssSelector("[data-test=error]")).isDisplayed();
        assertTrue(titleIsVisible, "Epic sadface: Username and password do not match any user in this service");
    }

/*
    Домашнее задание - тест 3
    1.Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение "(пробел) Arina"
    3. Оставить поле password пустым
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Password is required
     */

    @Test
    public void checkNegativeLoginWithEmptyPassword() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(errorMessage, "Epic sadface: Password is required");
    }
}
