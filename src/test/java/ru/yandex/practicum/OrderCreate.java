package ru.yandex.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.Pages.CreateOrderPage;
import ru.yandex.practicum.Pages.HomePage;

@RunWith(Parameterized.class)
public class OrderCreate extends BaseTest{
    private WebDriver driver;

    private int buttonIndex;
    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;
    private String rentTime;
    private String scooterColor;
    private String comment;

    public OrderCreate(int buttonIndex, String name, String surname, String address, String metro, String phone, String rent, String scooterColor, String comment ) {
        this.buttonIndex = buttonIndex;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.rentTime = rent;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "buttonIndex: {0}, name: {1}, surname: {2}, address: {3}, metro: {4}, phone: {5}, rent: {6}, color: {7}, comment: {8}")
    public static Object[][] getOrderParameters() {
        return new Object[][]{
                {0, "Виктор", "Иванов", "ул. Ленина 55 - 67", "Бульвар Рокоссовского", "89500005555", "сутки", "black", ""},
                {1, "Анна", "Оболонская", "проспект Художников 55, кв. 67", "Лихоборы", "+79500005555", "семеро суток", "grey", "вторая парадная"},
        };
    }

    @Before
    public void setUp() {
        driver = getBaseDriver();
        driver.get(baseUrl);
    }

    @Test
    public void orderCreateRegularValuePositiveResult() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton(buttonIndex);

        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.waitUntilPageOpen();

        createOrderPage.setName(name);
        createOrderPage.setSurname(surname);
        createOrderPage.setAddress(address);
        createOrderPage.selectMetro(metro);
        createOrderPage.setPhone(phone);
        createOrderPage.clickButtonNext();
        createOrderPage.selectDate();
        createOrderPage.setRentTime(rentTime);
        createOrderPage.selectScooterColor(scooterColor);
        createOrderPage.setComment(comment);
        createOrderPage.clickButtonOrder();
        createOrderPage.clickButtonConfirmOrder();

        createOrderPage.checkOrderCreated();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
