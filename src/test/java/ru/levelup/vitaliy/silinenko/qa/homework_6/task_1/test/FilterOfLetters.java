package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.TestBase;

public class FilterOfLetters extends TestBase {

    @DataProvider(name = "DataTest")
    public Object[][] DataTest() {
        return new Object[][]{
                {"tester.csi@list.ru", "testSubject \"Тест\"", "testBody"}
        };
    }

    @Test (dataProvider = "DataTest")
    public void filterOfLettersTest( String email, String subject, String body){

        // Авторизация
        preparatorySteps.authorizationInMail();
        // assert, что авторизация успешна
        assertionSteps.assertThatAuthIsDone();
        // Удаление писем из всех папок
        preparatorySteps.deleteFromAllFolders();

        // Создание письма
        actionSteps.createLetter(email, subject, body);
        // Отправка письма
        actionSteps.sendLetter();

        // Переход в папку "Отправленные"
        actionSteps.navigateTo("Отправленные");
        // Проверка, что в папке есть письмо
        assertionSteps.assertCountOfLetters(1);

        // Переход в папку "Тест"
        actionSteps.navigateTo("Тест");
        // Открытие письма первого в списке
        actionSteps.openFirstLetter();
        // Проверка получателя, темы и тела письма
        assertionSteps.softAssertDataOfLetter(email, subject, body);

        // Выход
        preparatorySteps.exit();

    }
}
