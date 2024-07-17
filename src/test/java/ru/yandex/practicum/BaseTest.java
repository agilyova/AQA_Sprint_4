package ru.yandex.practicum;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    String baseUrl = "https://qa-scooter.praktikum-services.ru/";

    private String baseDriver = "Chrome";

    WebDriver getBaseDriver() {
        if (baseDriver.equals("Firefox")) {
            WebDriver driver = new FirefoxDriver(new FirefoxOptions().addArguments("--start-maximized"));
            driver.manage().window().setSize(new Dimension(1920, 1080));
            return driver;
            }
        else {
            return new ChromeDriver(new ChromeOptions().addArguments("--window-size=1920,1080"));
        }
    }
}