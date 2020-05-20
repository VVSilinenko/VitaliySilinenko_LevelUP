package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LetterInBasket extends TestBase {

    @DataProvider(name = "DataTest")
    public Object[][] DataTest() {
        return new Object[][]{
                {"tester.csi", "WgsXM9JS39kuvAC", "tester.csi@list.ru", "testSubject", "testBody"}
        };
    }

    @Test (dataProvider = "DataTest")
    public void letterInBasketTest(String login, String password, String email, String subject, String body){

        // Авторизация
        authPage.authorization(login, password);
        // assert, что авторизация успешна
        assertTrue(homePage.getWriteLetterButton().isEnabled());
        // Удаление писем из всех папок
        homePage.deleteFromAllFolder();

        // Нажатие на "Написать письмо"
        homePage.clickWriteLetterButton();
        // Заполнение полей письма
        createPage.fillLetterFields(email, subject, body);
        // Нажатие на "Отправить"
        createPage.clickSendLetterButton();

        // Переход во "Входящие"
        homePage.goToInbox();
        // Открытие письма по индексу 0
        inboxPage.openLetterByIndex(0);
        // Проверка получателя, темы и тела письма
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(inboxPage.getSenderField().getAttribute("title"), login + "@list.ru");
        sa.assertEquals(inboxPage.getSubjectField().getText(), subject);
        sa.assertTrue(inboxPage.getBodyField().getText().contains(body));
        sa.assertAll();
        // Удаление письма
        inboxPage.clickDeleteButton();

        // Переход в "Корзина"
        homePage.goToTrash();
        // Проверка, что письмо появилось в "Корзина"
        assertEquals(trashPage.getLettersList().size(), 1);

        // Выход
        homePage.exit();
    }
}
