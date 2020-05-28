package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SaveInDrafts extends TestBase {

    @DataProvider(name = "DataTest")
    public Object[][] DataTest() {
        return new Object[][]{
                {"tester.csi@list.ru", "testSubject", "testBody"}
        };
    }

    @Test (dataProvider = "DataTest")
    public void saveInDraftsTest(String email, String subject, String body) {


        // Авторизация
        authPage.authorization();
        // assert, что авторизация успешна
        assertTrue(homePage.getWriteLetterButton().isEnabled());
        // Удаление писем из всех папок
        homePage.deleteFromAllFolder();

        // Нажатие на "Написать письмо"
        homePage.clickWriteLetterButton();
        // Заполнение полей письма
        createPage.fillLetterFields(email, subject, body);
        // Нажатие на "Сохранить"
        createPage.clickSaveLetterButton();
        // Нажатие на крестик для закрытия формы
        createPage.clickCloseLetterButton();

        // Переход в "Черновики"
        homePage.goToDrafts();
        // Открытие письма по индексу 0
        draftsPage.openLetterByIndex(0);
        // Проверка получателя, темы и тела письма
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(createPage.isEmptyRecipient(email));
        sa.assertEquals(createPage.getSubjectField(), subject);
        sa.assertTrue(createPage.getBodyField().contains(body), "Тело письма не содержит ожидаемого текста");
        sa.assertAll();
        // Нажатие на "Отправить"
        createPage.clickSendLetterButton();
        // Проверка, что письмо из "Черновики" ушло
        assertEquals(homePage.getPopupMessageDrafts(), "Черновики, нет писем");

        // Переход во "Входящие"
        homePage.goToInbox();
        // Открытие письма по индексу 0
        inboxPage.openLetterByIndex(0);
        // Проверка получателя, темы и тела письма
        sa.assertEquals(inboxPage.getSenderField(), email);
        sa.assertEquals(inboxPage.getSubjectField(), subject);
        sa.assertTrue(inboxPage.getBodyField().contains(body), "Тело письма не содержит ожидаемого текста");
        sa.assertAll();

        // Выход
        homePage.exit();
    }



}
