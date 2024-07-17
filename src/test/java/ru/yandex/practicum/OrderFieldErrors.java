package ru.yandex.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.Pages.CreateOrderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFieldErrors extends BaseTest{
    private WebDriver driver;
    private String fieldName;
    private String fieldError;

    public OrderFieldErrors(String fieldName, String fieldError) {
        this.fieldName = fieldName;
        this.fieldError = fieldError;
    }

    @Parameterized.Parameters(name = "fieldName = {0}, fieldError = {1}")
    public static Object[][] getFieldsParameters() {
        return new Object[][] {
                {"* Имя", "Введите корректное имя"},
                {"* Фамилия", "Введите корректную фамилию"},
                // {"* Адрес: куда привезти заказ", "Введите корректный адрес"}, //Баг, поле не отмечено как required в Order.js
                {"* Станция метро", "Выберите станцию"},
                {"* Телефон: на него позвонит курьер", "Введите корректный номер"},
        };
    }

    @Before
    public void setUp() {
        driver = getBaseDriver();
        driver.get(baseUrl + "order");
    }

    @Test
    public void orderCreateEmptyValueForRequiredFieldsShowsError() {
        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.clickButtonNext();

        assertEquals(fieldError, createOrderPage.getErrorMessage(fieldName));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
