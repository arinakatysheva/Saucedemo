package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage; //инициализируем страницу с авторизацией
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    OverviewPage overviewPage;
    CompletePage completePage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); //не открывать браузер
        options.addArguments("--start-maximized"); //открыть в максимальном размере
        options.addArguments("--incognito"); //открыть браузер в режиме инкогнито
        options.addArguments("--disable_notification"); //отключить всплывающие уведомления

        driver = new ChromeDriver(options); //настройка драйвера
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage (driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
