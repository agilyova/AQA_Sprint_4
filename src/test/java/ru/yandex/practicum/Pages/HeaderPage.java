package ru.yandex.practicum.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By scooterLogo = By.xpath(".//a[contains(@class, 'Header_LogoScooter')]");
    private By yandexLogo = By.xpath(".//a[contains(@class, 'Header_LogoYandex')]");
    private By orderStatusButton = By.xpath(".//button[text() = 'Статус заказа']");
    private By orderNumberInput = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    private By goButton = By.xpath(".//button[text() = 'Go!']");

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void setOrderNumber(String orderNumber) {
        WebElement orderNumberInputElement = driver.findElement(orderNumberInput);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderNumberInputElement));
        orderNumberInputElement.sendKeys(orderNumber);
    }

    public void checkYandexMainPageIsOpened() {
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        new WebDriverWait(driver, 3).until(ExpectedConditions.urlContains("https://dzen.ru/"));
    }
}
