package ru.yandex.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.Pages.HeaderPage;
import ru.yandex.practicum.Pages.HomePage;

public class BaseFunctionality extends BaseTest{
    WebDriver driver;

    @Before
    public void setUp() {
        driver = getBaseDriver();
    }

    @Test
    public void questionClickShowsAnswer() {
        driver.get(baseUrl);

        HomePage homePage = new HomePage(driver);
        homePage.clickQuestion("Хочу сразу несколько самокатов! Так можно?");

        homePage.checkTheAnswerIsCorrectAndVisible("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
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
