package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.TestBase;

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
        preparatorySteps.authorizationInMail();
        // assert, что авторизация успешна
        assertionSteps.assertThatAuthIsDone();
        // Удаление писем из всех папок
        preparatorySteps.deleteFromAllFolders();

        // Создание письма
        actionSteps.createLetter(email, subject, body);
        // Сохранение письма в черновиках
        actionSteps.saveLetter();

        // Переход в "Черновики"
        actionSteps.navigateTo("Черновики");
        // Открытие письма по индексу 0
        actionSteps.openFirstLetter();
        // Проверка получателя, темы и тела письма
        assertionSteps.softAssertDataOfLetterFromDrafts(email, subject, body);
        // Нажатие на "Отправить"
        actionSteps.sendLetter();
        // Проверка, что письмо из "Черновики" ушло
        assertionSteps.assertThatDraftsIsEmpty();

        // Переход во "Входящие"
        actionSteps.navigateTo("Входящие");
        // Открытие письма по индексу 0
        actionSteps.openFirstLetter();
        // Проверка получателя, темы и тела письма
        assertionSteps.softAssertDataOfLetter(email, subject, body);

        // Выход
        preparatorySteps.exit();
    }



}
