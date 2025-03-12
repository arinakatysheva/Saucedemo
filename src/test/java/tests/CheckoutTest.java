package tests;

import dto.Customer;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
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

    Customer customer = new Customer("Ivan", "Ivanov", "123456");

    @Test
    @Link("https://www.saucedemo.com")
    @TmsLink("www.testrail.com/SD/SD-01") //тест-кейс №01 в проекте Saucedemo
    @Issue("www.jira.com/SD/BUG-01") //баг №01 в проекте Saucedemo
    @Flaky //значок бомбочки для часто падающих тестов
    @Severity(SeverityLevel.CRITICAL) //критическая серьезность
    @Description("Сквозное тестирование приложения") //описание теста
    @Epic("HSE-03") //глобальное описание функциональности
    @Feature("HSE-03-01")
    @Story("HSE-03-01-01") //что тестируем автоматизированным тестом
    @Owner("Катышева Арина")

    public void checkout() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .clickToCart()
                .clickToCheckout()
                .fillingForm(customer)
                .clickToContinue()
                .clickToFinish();
        assertEquals(completePage.getCompleteMessage(),
                "Thank you for your order!",
                "Сообщение о покупке не отобразилось"
        ); //сообщение о несоотвествии ожидаемого и фактического результатов
    }
}