import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    /*
    Негативный тест:
    1. Открыть страницу https://www.saucedemo.com
    2. Ввести в поле username значение "standard_user"
    3. Ввести в поле password "(пробел)"
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Username and password do not match any user in this service
     */

    @Test // аннотация
    public void checkNegativeLogin() {
        WebDriver driver = new ChromeDriver(); //инициализация браузера (Chrome)
        driver.manage().window().maximize(); //настройки браузера (максимальный размер открывающегося окна)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание (10 секунд на появление элемента на странице)

        driver.get("https://www.saucedemo.com"); //получить страницу

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //ввести логин (локатор id из xtml-файла)
        driver.findElement(By.id("password")).sendKeys(" "); //ввести пароль
        driver.findElement(By.id("login-button")).click(); //нажать кнопку "Login"

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText(); //вывести сообщение об ошибке
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service"); //сравнить между собой два значения

        driver.quit();
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
    public void checkPositiveLogin() {
        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); 
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); 
        driver.findElement(By.id("login-button")).click(); 

        boolean titleIsVisible = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed(); 
        Assert.assertTrue(titleIsVisible, "Products"); 
        
        driver.quit();
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(" Arina");
        driver.findElement(By.id("password")).sendKeys("Katysheva");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("Katysheva");
        driver.findElement(By.id("login-button")).click();

        boolean titleIsVisible = driver.findElement(By.cssSelector("[data-test=error]")).isDisplayed();
        Assert.assertTrue(titleIsVisible, "Epic sadface: Username and password do not match any user in this service");
        
        driver.quit();
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");

        driver.quit();
    }
}
