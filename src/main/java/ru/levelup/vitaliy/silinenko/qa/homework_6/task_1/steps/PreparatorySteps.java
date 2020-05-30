package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps;

import org.openqa.selenium.WebDriver;

public class PreparatorySteps extends AbstractBaseStep {

    public PreparatorySteps(WebDriver driver) {
        super(driver);
    }

    // Авторизация
    public void authorizationInMail(){
        authPage.authorization();
    }

    // Удаление писем из папок
    public void deleteFromAllFolders(){
        homePage.deleteFromAllFolder();
    }

    // Выход
    public void exit(){
        homePage.exit();
    }

}
