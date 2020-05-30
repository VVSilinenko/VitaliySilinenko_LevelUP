package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class AssertionSteps extends AbstractBaseStep {

    public AssertionSteps(WebDriver driver) {
        super(driver);
    }

    // Проверка корректности авторизации
    public void assertThatAuthIsDone(){
        assertTrue(homePage.getWriteLetterButton().isEnabled());
    }

    // Проверка количества писем в папке
    public void assertCountOfLetters(int actualSize){
        assertEquals(baseFolderPage.getLettersListSize(), actualSize);
    }

    // Проверка данных письма в папке
    public void softAssertDataOfLetter(String actualEmail, String actualSubject, String actualBody){
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(baseFolderPage.getSenderField(), actualEmail);
        sa.assertEquals(baseFolderPage.getSubjectField(), actualSubject);
        sa.assertTrue(baseFolderPage.getBodyField().contains(actualBody), "Тело письма не содержит ожидаемого текста");
        sa.assertAll();
    }

    // Проверка, что папка Черновики пустая
    public void assertThatDraftsIsEmpty(){
        assertEquals(homePage.getPopupMessageDrafts(), "Черновики, нет писем");
    }

    // Проверка данных письма в форме создания письма
    public void softAssertDataOfLetterFromDrafts(String actualEmail, String actualSubject, String actualBody){
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(createPage.getRecipientName(), actualEmail);
        sa.assertEquals(createPage.getSubjectField(), actualSubject);
        sa.assertTrue(createPage.getBodyField().contains(actualBody), "Тело письма не содержит ожидаемого текста");
        sa.assertAll();
    }
}
