package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By TITLE = By.cssSelector("[data-test=title]");
    private static final String ADD_TO_CART = "//div[text() = '%s']/ancestor::div[@class='inventory_item']//button";
    private static final By CART_BUTTON = By.id("shopping_cart_container");

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed(); //метод взаимодействия с элементом
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, product))).click(); //добавить товар в корзину
    }

    public void clickToCart() {
        driver.findElement(CART_BUTTON).click();
    }
}
