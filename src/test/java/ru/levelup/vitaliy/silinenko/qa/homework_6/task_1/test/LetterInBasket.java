package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.TestBase;

public class LetterInBasket extends TestBase {

    @DataProvider(name = "DataTest")
    public Object[][] DataTest() {
        return new Object[][]{
                {"tester.csi@list.ru", "testSubject", "testBody"}
        };
    }

    @Test (dataProvider = "DataTest")
    public void letterInBasketTest(String email, String subject, String body){

        // Авторизация
        preparatorySteps.authorizationInMail();
        // assert, что авторизация успешна
        assertionSteps.assertThatAuthIsDone();
        // Удаление писем из всех папок
        preparatorySteps.deleteFromAllFolders();

        // Нажатие на "Написать письмо"
        actionSteps.createLetter(email, subject, body);
        // Нажатие на "Отправить"
        actionSteps.sendLetter();

        // Переход во "Входящие"
        actionSteps.navigateTo("Входящие");
        // Открытие письма по индексу 0
        actionSteps.openFirstLetter();
        // Проверка получателя, темы и тела письма
        assertionSteps.softAssertDataOfLetter(email, subject, body);
        // Удаление письма
        actionSteps.deleteLetter();

        // Переход в "Корзина"
        actionSteps.navigateTo("Корзина");
        // Проверка, что письмо появилось в "Корзина"
        assertionSteps.assertCountOfLetters(1);

        // Выход
        preparatorySteps.exit();
    }
}
