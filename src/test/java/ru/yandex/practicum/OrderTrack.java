package ru.yandex.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.Pages.HeaderPage;
import ru.yandex.practicum.Pages.OrderTrackPage;

public class OrderTrack extends BaseTest{
    WebDriver driver;

    @Before
    public void setUp() {
        driver = getBaseDriver();
        driver.get(baseUrl);
    }

    @Test
    public void orderTrackEmptyValueShowsNotFoundImage() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOrderStatusButton();
        headerPage.setOrderNumber("123");
        headerPage.clickGoButton();

        new OrderTrackPage(driver).checkNotFoundImageDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
