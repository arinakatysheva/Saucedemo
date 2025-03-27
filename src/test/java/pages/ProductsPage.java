package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By TITLE = By.cssSelector("[data-test=title]");
    private static final String ADD_TO_CART = "//div[text() = '%s']/ancestor::div[@class='inventory_item']//button";
    private static final By CART_BUTTON = By.id("shopping_cart_container");

    @Step("Страница с товарами")
    public boolean isPageOpened() {
        log.info("Страница с товарами");
        return driver.findElement(TITLE).isDisplayed(); //метод взаимодействия с элементом
    }

    @Step("Добавление в корзину товара - {product}") //будет показывать, какой товар добавили в корзину
    public ProductsPage addToCart(String product) {
        log.info("Добавление в корзину товара - {}", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART, product))).click(); //добавить товар в корзину
        return this;
    }

    @Step("Нажатие на иконку корзины")
    public CartPage clickToCart() {
        log.info("Нажатие на иконку корзины");
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}
