package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateLetterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CreateLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Поле "Кому"
    @FindBy (xpath = "//div[@data-name='to']//input[@type='text']")
    private WebElement recipientField;

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
        wait = new WebDriverWait(driver, 10);
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
        wait = new WebDriverWait(driver, 10);
        sendLetterButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeFormAfterSendLetterButton)).click();
    }

    // Проверка на наличие в списке получателей
    public boolean isEmptyRecipient(String recipientName){
        List<WebElement> recipients = contactsList;
        for (WebElement recipient : recipients) {
            if (recipient.getAttribute("title").equals(recipientName)){
                return true;
            }
        }
        return false;
    }

    public WebElement getSubjectField() {
        return subjectField;
    }

    public WebElement getBodyField() {
        return bodyField;
    }
}
