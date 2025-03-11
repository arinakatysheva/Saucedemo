package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver(); //настройка драйвера
        driver.manage().window().maximize();
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
