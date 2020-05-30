package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateLetterPage extends BasePage {

    public CreateLetterPage(WebDriver driver) {
        super(driver);
    }

    // Поле "Кому"
    @FindBy (xpath = "//div[@data-name='to']//input[@type='text']")
    private WebElement recipientField;

    // Поле "Кому", имя получателя
    @FindBy (xpath = "//div[contains(@class, 'contactsContainer')]//div[contains(@class, 'status_base')]")
    private WebElement recipientName;

    // Поле "Тема"
    @FindBy (name = "Subject")
    private WebElement subjectField;

    // Тело письма
    @FindBy (xpath = "//div[@aria-multiline='true']")
    private WebElement bodyField;

    // Кнопка "Отправить"
    @FindBy (xpath = "//div[@class='compose-app__buttons']//span[text()='Отправить']")
    private WebElement sendLetterButton;

    // Кнопка "Сохранить"
    @FindBy (xpath = "//div[@class='compose-app__buttons']//span[text()='Сохранить']")
    private WebElement saveLetterButton;

    // Крестик для закрытия формы
    @FindBy (xpath = "//button[@title='Закрыть']")
    private WebElement closeLetterButton;

    // Крестик для закрытия формы при отправлении письма
    @FindBy (xpath = "//span[@title='Закрыть']")
    private WebElement closeFormAfterSendLetterButton;

    // Список получателей
    @FindBy (xpath = "//div[contains(@class, 'contacts')]//div[contains(@class,'contact')][@data-type='to']//div[contains(@class,'status')]")
    private List<WebElement> contactsList;

    // Заполнение полей письма
    public void fillLetterFields(String email, String subject, String body){
        wait.until(ExpectedConditions.elementToBeClickable(recipientField)).sendKeys(email);
        subjectField.sendKeys(subject);
        bodyField.sendKeys(body);
    }

    // Нажатие на кнопку "Сохранить"
    public void clickSaveLetterButton(){
        saveLetterButton.click();
    }

    // Нажатие на крестик для закрытия формы
    public void clickCloseLetterButton(){
        closeLetterButton.click();
    }

    // Нажатие на кнопку "Отправить"
    public void clickSendLetterButton(){
        sendLetterButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeFormAfterSendLetterButton)).click();
    }

    public String getRecipientName() {
        return recipientName.getAttribute("title");
    }

    public String getSubjectField() {
        return subjectField.getAttribute("value");
    }

    public String getBodyField() {
        return bodyField.getText();
    }
}
