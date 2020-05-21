package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilterOfLetters extends TestBase {

    @DataProvider(name = "DataTest")
    public Object[][] DataTest() {
        return new Object[][]{
                {"tester.csi", "WgsXM9JS39kuvAC", "tester.csi@list.ru", "testSubject \"Тест\"", "testBody"}
        };
    }

    @Test (dataProvider = "DataTest")
    public void filterOfLettersTest(String login, String password, String email, String subject, String body){

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

        // Переход в папку "Отправленные"
        homePage.goToSent();
        // Проверка, что в папке есть письмо
        assertEquals(sentPage.getLettersList().size(), 1);

        // Переход в папку "Тест"
        homePage.goToTest();
        // Открытие письма по индексу 0
        testPage.openLetterByIndex(0);
        // Проверка получателя, темы и тела письма
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(testPage.getSenderField().getAttribute("title"), login + "@list.ru");
        sa.assertEquals(testPage.getSubjectField().getText(), subject);
        sa.assertTrue(testPage.getBodyField().getText().contains(body), "Тело письма не содержит ожидаемого текста");
        sa.assertAll();

        // Выход
        homePage.exit();

    }
}
