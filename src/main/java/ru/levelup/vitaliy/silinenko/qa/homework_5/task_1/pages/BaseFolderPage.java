package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFolderPage {

    private WebDriver driver;

    BaseFolderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
        List<WebElement> letters = lettersList;
        if (letters.size() > 0 && index < letters.size()) {
            letters.get(index).click();
        }
    }

    // Нажатие на кнопку "Удалить"
    public void clickDeleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    public WebElement getSenderField() {
        return senderField;
    }

    public WebElement getSubjectField() {
        return subjectField;
    }

    public WebElement getBodyField() {
        return bodyField;
    }

    public List<WebElement> getLettersList() {
        return lettersList;
    }
}
