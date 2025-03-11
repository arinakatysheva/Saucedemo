package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CHECKOUT_BUTTON = By.id("checkout");

    public void clickToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
