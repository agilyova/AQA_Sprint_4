package ru.yandex.practicum.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderTrackPage {
    private WebDriver driver;

    public OrderTrackPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderForm = By.xpath(".//div[contains(@class, 'Track_Form')]");
    private By notFoundImg = By.xpath(".//img[@alt = 'Not found']");

    public void waitUntilPageOpen() {
        WebElement orderFormElement = driver.findElement(orderForm);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(orderFormElement));
    }

    public void checkNotFoundImageDisplayed() {
        WebElement notFoundImageElement = driver.findElement(notFoundImg);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(notFoundImageElement));
    }
}
