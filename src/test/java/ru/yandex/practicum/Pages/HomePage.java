package ru.yandex.practicum.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопки Заказать
    private By buttonOrder = By.xpath(".//button[text() = 'Заказать']");

    //Вспомогательное поле для поиска ответа на вопрос
    private String questionId;

    //Альтернативный поиск ответа, тк сейчас аккордион схлопывается можно сделать так, но будет менее читабельная ошибка
    //private By answer = By.xpath(".//div[@class = 'accordion__panel' and not(@hidden)]");

    public void clickOrderButton(int index) {
        WebElement button = driver.findElements(buttonOrder).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

    public void clickQuestion(String question) {
        WebElement questionElement = driver.findElement(By.xpath(".//div[text() = '" + question + "']"));
        questionId = questionElement.getAttribute("id");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        questionElement.click();
    }

    public void checkTheAnswerIsCorrectAndVisible(String expectedAnswer) {
        WebElement answerElement = driver.findElement(By.xpath(".//div[@aria-labelledby = '" + questionId + "']"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(answerElement));
        String factAnswer = answerElement.getText();

        assertTrue("Ответ должен быть виден", answerElement.isDisplayed());
        assertEquals(expectedAnswer, factAnswer);
    }
}
