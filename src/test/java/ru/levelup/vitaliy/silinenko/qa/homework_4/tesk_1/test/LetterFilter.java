package ru.levelup.vitaliy.silinenko.qa.homework_4.tesk_1.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LetterFilter extends TestBase {

    @Test
    public void letterFilterTest(){
        String email = "tester.csi@list.ru";
        String subject = "Тема, в которой есть слово \"Тест\"";
        String body = "testBody";

        // Проверка, что авторизация корректна (ожидание, что кнопка "Написать письмо" кликабельна и нажатие на нее)
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[text()='Написать письмо']"))).click();
        // Заполнение поля "От кого"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@data-name='to']//input[@type='text']"))).sendKeys(email);
        // Заполнение поля "Тема"
        wait.until(ExpectedConditions.elementToBeClickable(name("Subject"))).sendKeys(subject);
        // Заполнение тела письма
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@aria-multiline='true']"))).sendKeys(body);
        // Нажатие на "Отправить"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='compose-app__buttons']//span[text()='Отправить']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Закрыть']"))).click();
        // Переход в "Отправленные"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Отправленные']"))).click();
        // Подсчет всех писем в "Отправленные"
        List<WebElement> draftList = driver.findElements(xpath("//div[@class='dataset__items']//div[@class='llc__item llc__item_correspondent']"));
        // Переход в первое письмо
        wait.until(ExpectedConditions.elementToBeClickable(draftList.get(0))).click();
        // Проверки e-mail, темы и текста письма
        assertEquals(wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='letter__author']/span"))).getAttribute("title"), email);
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(tagName("h2"))).getText().contains(subject), "Тема письма не содержит необходимого текста");
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(cssSelector("div[id$='BODY']"))).getText().contains(body), "Тело письма не содержит необходимого текста");
        // Переход в "Тест"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Тест']"))).click();
        // Подсчет всех писем в "Тест"
        draftList = driver.findElements(xpath("//div[@class='dataset-letters']//span[@class='ll-crpt']"));
        // Переход в первое письмо
        draftList.get(0).click();
        // Проверки e-mail, темы и текста письма
        assertEquals(wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='letter__author']/span"))).getAttribute("title"), email);
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(tagName("h2"))).getText().contains(subject), "Тема письма не содержит необходимого текста");
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(cssSelector("div[id$='BODY']"))).getText().contains(body), "Тело письма не содержит необходимого текста");
        // Выход
        wait.until(ExpectedConditions.elementToBeClickable(id("PH_logoutLink"))).click();

    }
}
