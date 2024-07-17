package ru.yandex.practicum.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateOrderPage {
    private WebDriver driver;

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заголовок страницы
    private By title = By.xpath(".//div[text() = 'Для кого самокат']");
    //Поля Имя
    private By name = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    //Поле Фамилия
    private By surname = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    //Поле Адрес, куда привезти
    private By address = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    //Поле Станция метро
    private By metro = By.xpath(".//input[contains(@placeholder, 'метро')]");
    //Поле Телефон: на него возвонит курьер
    private By phone = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    //Поле Когда привезти самокат
    private By date = By.xpath(".//input[contains(@placeholder, 'Когда привезти самокат')]");
    //Поле Срок аренды
    private By rentTime = By.xpath(".//div[contains(text(), 'Срок аренды')]");
    //Выпадающий список срока аренды
    private By rentMenu = By.className("Dropdown-menu");
    //Дата в календаре
    private By datePicker = By.xpath(".//div[@class = 'react-datepicker__week'][last()]/div[last()]");
    //Поле Комментарий для курьера
    private By comment = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    //Форма заказа
    private By orderForm = By.xpath(".//div[contains(@class, 'Order_Form')]");

    //Кнопка Заказать
    private By buttonOrder = By.xpath(".//div[contains(@class,'Order')]//button[text() = 'Заказать']");
    //Кнопка Далее
    private By buttonNext = By.xpath(".//button[text() = 'Далее']");
    //Уведомление об успешном заказе
    private By successOrderInfo = By.xpath(".//div[text() = 'Заказ оформлен']");
    //Кнопка подтверждения заказа
    private By buttonConfirmOrder = By.xpath(".//button[text() = 'Да']");

    public void waitUntilPageOpen() {
        WebElement element = driver.findElement(title);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }

    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    public void selectMetro(String metro) {
        driver.findElement(this.metro).sendKeys(metro);
        driver.findElement(By.xpath(".//div[text() = '" + metro + "']")).click();
    }

    public void setPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }

    public void selectDate() {
        driver.findElement(date).click();
        driver.findElement(datePicker).click();
    }

    public void setRentTime(String rentTime) {
        driver.findElement(this.rentTime).click();
        driver.findElement(rentMenu).findElement(By.xpath(".//div[text() = '" + rentTime + "']")).click();
    }

    public void selectScooterColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void clickButtonConfirmOrder() {
        driver.findElement(buttonConfirmOrder).click();
    }

    public void checkOrderCreated() {
        WebElement infoElement = driver.findElement(successOrderInfo);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(infoElement));
    }

    public String getErrorMessage(String fieldName) {
        WebElement form = driver.findElement(orderForm);
        int fieldNumber = getFieldNumberByName(fieldName) + 1;

        WebElement errorElement = form.findElement(By.xpath("div["+ fieldNumber +"]/div[contains(@class,'Error')]"));
        return errorElement.getText();
    }

    private int getFieldNumberByName(String name) {
        WebElement form = driver.findElement(orderForm);
        List<WebElement> elementsList = form.findElements(By.xpath(".//*[@placeholder]"));

        for (int i = 0; i < elementsList.size(); i++) {
            if (name.equals(elementsList.get(i).getAttribute("placeholder"))) {
                return i;
            }
        }
        return -1;
    }
}
