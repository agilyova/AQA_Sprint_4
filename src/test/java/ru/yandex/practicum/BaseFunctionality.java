package ru.yandex.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.Pages.HeaderPage;

public class BaseFunctionality extends BaseTest{
    WebDriver driver;

    @Before
    public void setUp() {
        driver = getBaseDriver();
    }

    @Test
    public void scooterLogoClickOpenHomePage() {
        driver.get(baseUrl + "order");

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickScooterLogo();

        Assert.assertEquals(baseUrl, driver.getCurrentUrl());
    }

    @Test
    public void yandexLogoClickOpenYandexMainPage() {
        driver.get(baseUrl);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickYandexLogo();

        headerPage.checkYandexMainPageIsOpened();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
