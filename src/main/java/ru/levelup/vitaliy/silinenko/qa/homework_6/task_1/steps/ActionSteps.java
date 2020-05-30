package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps;

import org.openqa.selenium.WebDriver;

public class ActionSteps extends AbstractBaseStep {

    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    // Переход в папку
    public void navigateTo(String folderName){
        homePage.goToFolder(folderName);
    }

    // Создание письма
    public void createLetter(String email, String subject, String body){
        homePage.clickWriteLetterButton();
        createPage.fillLetterFields(email, subject, body);
    }

    // Отправить письмо
    public void sendLetter(){
        createPage.clickSendLetterButton();
    }

    // Открытие первого письма
    public void openFirstLetter(){
        baseFolderPage.openLetterByIndex(0);
    }

    // Удаление письма
    public void deleteLetter(){
        baseFolderPage.clickDeleteButton();
    }

    // Сохранение письма в черновиках
    public void saveLetter(){
        createPage.clickSaveLetterButton();
        createPage.clickCloseLetterButton();
    }

}
