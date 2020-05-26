package ru.levelup.vitaliy.silinenko.qa.homework_4.tesk_1.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DraftsSave extends TestBase {

    @Test
    public void draftSaveTest() {
        String email = "tester.csi@list.ru";
        String subject = "testSubject";
        String body = "testBody";

        // Проверка, что авторизация корректна (ожидание, что кнопка "Написать письмо" кликабельна и нажатие на нее)
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[text()='Написать письмо']"))).click();
        // Заполнение поля "От кого"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@data-name='to']//input[@type='text']"))).sendKeys(email);
        // Заполнение поля "Тема"
        wait.until(ExpectedConditions.elementToBeClickable(name("Subject"))).sendKeys(subject);
        // Заполнение тела письма
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@aria-multiline='true']"))).sendKeys(body);
        // Нажатие на "Сохранить"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='compose-app__buttons']//span[text()='Сохранить']"))).click();
        // Закрытие окна создания письма
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//button[@title='Закрыть']"))).click();

        // Переход в "Черновики"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Черновики']"))).click();
        // Подсчет всех писем в "Черновиках"
        List<WebElement> draftList = driver.findElements(xpath("//div[@class='dataset-letters']//span[@class='ll-crpt']"));
        // Переход в первое письмо
        draftList.get(0).click();
        // Проверки e-mail, темы и текста письма
        assertEquals(wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@data-type='to'][@tabindex='-1']/div/div"))).getText(), email);
        assertEquals(wait.until(ExpectedConditions.elementToBeClickable(name("Subject"))).getAttribute("value"), subject);
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@aria-multiline='true']"))).getText().contains(body), "Тело письма не содержит необходимого текста");
        // Нажатие на "Отправить"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='compose-app__buttons']//span[text()='Отправить']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@title='Закрыть']"))).click();
        // Проверка, что письмо исчезло из "Черновиков"
        assertEquals(driver.findElement(xpath("//a[@href='/drafts/']")).getAttribute("title"), "Черновики, нет писем");
        // Переход во "Входящие"
        wait.until(ExpectedConditions.elementToBeClickable(xpath("//div[@class='nav__folder-name__txt'][text()='Входящие']"))).click();
        draftList = driver.findElements(xpath("//div[@class='dataset-letters']//span[@class='ll-crpt']"));
        // Переход в письмо
        draftList.get(0).click();
        // Проверки e-mail, темы и текста письма
        assertEquals(wait.until(ExpectedConditions.elementToBeClickable(xpath("//span[@class='letter-contact']"))).getAttribute("title"), email);
        assertEquals(wait.until(ExpectedConditions.elementToBeClickable(tagName("h2"))).getText(), subject);
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(cssSelector("div[id$='BODY']"))).getText().contains(body), "Тело письма не содержит необходимого текста");
        // Выход
        wait.until(ExpectedConditions.elementToBeClickable(id("PH_logoutLink"))).click();
    }
}
