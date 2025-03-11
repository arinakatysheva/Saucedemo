package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    /*
    1. Открыть страницу логина
    2. Ввести данные пользователя (логин и пароль)
    3. Нажать кнопку "add to cart" для определенного товара
    4. Нажать на иконку корзины
    5. Нажать кнопку "Checkout"
    6. Ввести данные покупателя (имя, фамилия, индекс)
    7. Нажать кнопку "Continue"
    8. Нажать кнопку "Finish"
    9. Проверить, что на экране присутствует сообщение с текстом
       Thank you for your order!
     */

    @Test
    public void checkout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.clickToCart();
        cartPage.clickToCheckout();
        checkoutInformationPage.fillingForm("Ivan", "Ivanov", "123456");
        checkoutInformationPage.clickToContinue();
        overviewPage.clickToFinish();
        Assert.assertEquals(completePage.getCompleteMessage(), "Thank you for your order!");
    }
}
