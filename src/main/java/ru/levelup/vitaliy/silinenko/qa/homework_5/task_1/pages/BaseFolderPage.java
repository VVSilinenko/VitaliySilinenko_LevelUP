package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFolderPage extends BasePage {

    protected BaseFolderPage(WebDriver driver) {
        super(driver);
    }

    // Список писем
    @FindBy(xpath = "//div[@class='dataset-letters']//span[@class='ll-crpt']")
    private List<WebElement> lettersList;

    // Поле "От кого"
    @FindBy(xpath = "//span[@class='letter-contact']")
    private WebElement senderField;

    // Поле "Тема"
    @FindBy(tagName = "h2")
    private WebElement subjectField;

    // Тело письма
    @FindBy(css = "div[id$='BODY']")
    private WebElement bodyField;

    // Кнопка "Удалить"
    @FindBy (xpath = "//span[@class='button2__txt'][text()='Удалить']")
    private WebElement deleteButton;

    // Открытие письма по индексу
    public void openLetterByIndex(int index){
        if (lettersList.size() > 0 && index < lettersList.size()) {
            lettersList.get(index).click();
        }
    }

    // Нажатие на кнопку "Удалить"
    public void clickDeleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    public String getSenderField() {
        return senderField.getAttribute("title");
    }

    public String getSubjectField() {
        return subjectField.getText();
    }

    public String getBodyField() {
        return bodyField.getText();
    }

    public int getLettersListSize() {
        return lettersList.size();
    }
}
