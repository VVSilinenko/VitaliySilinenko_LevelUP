package ru.levelup.vitaliy.silinenko.qa.homework_4.tesk_1.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;

public class TestBase {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");

        // Авторизация
        wait.until(ExpectedConditions.elementToBeClickable(id("mailbox:login"))).sendKeys("tester.csi");
        driver.findElement(id("mailbox:domain")).click();
        List<WebElement> domains = driver.findElements(xpath("//select[@id='mailbox:domain']/option"));
        for (WebElement domain : domains) {
            if (domain.getText().equals("@list.ru")) {
                domain.click();
                break;
            }
        }
        driver.findElement(id("mailbox:domain")).click();
        driver.findElement(cssSelector("input[value='Ввести пароль']")).click();
        driver.findElement(id("mailbox:password")).sendKeys("WgsXM9JS39kuvAC");
        driver.findElement(id("mailbox:submit")).click();

        // Удаление всех писем из Входящих, Отправленных, Тест, Черновиков, Корзины
        // Удаление из "Входящие"
        if (!driver.findElement(xpath("//a[@href='/inbox/']")).getAttribute("title").equals("Входящие, нет писем")){
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Входящие']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(className("button2__explanation"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Удалить']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='layer__submit-button']//span[@class='button2__txt'][text()='Очистить']"))).click();
        }
        // Удаление из "Тест"
        if (!driver.findElement(xpath("//a[@href='/1/']")).getAttribute("title").equals("Тест, нет писем")){
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Тест']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(className("button2__explanation"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Удалить']"))).click();
        }
        // Удаление из "Отправленные"
        if (!driver.findElement(xpath("//a[@href='/sent/']")).getAttribute("title").equals("Отправленные, нет писем")){
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Отправленные']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(className("button2__explanation"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Удалить']"))).click();
        }
        // Удаление из "Черновики"
        if (!driver.findElement(xpath("//a[@href='/drafts/']")).getAttribute("title").equals("Черновики, нет писем")){
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Черновики']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(className("button2__explanation"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Удалить']"))).click();
        }
        // Удаление из "Корзина"
        if (!driver.findElement(xpath("//a[@href='/drafts/']")).getAttribute("title").equals("Корзина, нет писем")){
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Корзина']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(className("button2__explanation"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Удалить']"))).click();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
