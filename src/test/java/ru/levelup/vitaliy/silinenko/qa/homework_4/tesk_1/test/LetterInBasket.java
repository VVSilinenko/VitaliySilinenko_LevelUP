package ru.levelup.vitaliy.silinenko.qa.homework_4.tesk_1.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LetterInBasket extends TestBase {

    @Test
    public void letterInBasketTest() {
        String email = "tester.csi@list.ru";
        String subject = "testSubject";
        String body = "testBody";

        // Проверка, что авторизация корректна (ожидание, что кнопка "Написать письмо" кликабельна и нажатие на нее)
        driver.findElement(xpath("//span[text()='Написать письмо']")).click();
        // Заполнение поля "От кого"
        driver.findElement(xpath("//div[@data-name='to']//input[@type='text']")).sendKeys(email);
        // Заполнение поля "Тема"
        driver.findElement(name("Subject")).sendKeys(subject);
        // Заполнение тела письма
        driver.findElement(xpath("//div[@aria-multiline='true']")).sendKeys(body);
        // Нажатие на "Отправить"
        driver.findElement(xpath("//div[@class='compose-app__buttons']//span[text()='Отправить']")).click();
        driver.findElement(xpath("//span[@title='Закрыть']")).click();
        // Переход в "Входящие"
        driver.findElement(xpath("//div[@class='nav__folder-name__txt'][text()='Входящие']")).click();
        // Переход в письмо
        List<WebElement> draftList = driver.findElements(xpath("//div[@class='dataset-letters']//span[@class='ll-crpt']"));
        draftList.get(0).click();
        // Проверки e-mail, темы и текста письма
        assertEquals(driver.findElement(xpath("//div[@class='letter__author']/span")).getAttribute("title"), email);
        assertTrue(driver.findElement(tagName("h2")).getText().contains(subject));
        assertTrue(driver.findElement(cssSelector("div[id$='BODY']")).getText().contains(body));
        // Удаление письма
        driver.findElement(xpath("//span[@class='button2__txt'][text()='Удалить']")).click();
        // Переход в "Корзина"
        driver.findElement(xpath("//div[@class='nav__folder-name__txt'][text()='Корзина']")).click();
        // Переход в письмо
        driver.findElements(xpath("//div[@class='dataset-letters']//span[@class='ll-crpt']")).get(0).click();
        // Проверки e-mail, темы и текста письма
        assertEquals(driver.findElement(xpath("//div[@class='letter__author']/span")).getAttribute("title"), email);
        assertTrue(driver.findElement(tagName("h2")).getText().contains(subject));
        assertTrue(driver.findElement(cssSelector("div[id$='BODY']")).getText().contains(body));
        // Выход
        driver.findElement(id("PH_logoutLink")).click();

    }
}
