package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.pages.AuthPage;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.pages.BaseFolderPage;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.pages.CreateLetterPage;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.pages.HomePage;

public abstract class AbstractBaseStep {

    protected WebDriver driver;
    AuthPage authPage;
    HomePage homePage;
    CreateLetterPage createPage;
    BaseFolderPage baseFolderPage;

    AbstractBaseStep(WebDriver driver) {
        this.driver = driver;
        authPage = new AuthPage(driver);
        homePage = new HomePage(driver);
        baseFolderPage = new BaseFolderPage(driver);
        createPage = new CreateLetterPage(driver);
    }
}
