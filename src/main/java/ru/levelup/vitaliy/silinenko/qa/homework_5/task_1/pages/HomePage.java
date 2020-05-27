package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Выход"
    @FindBy (id = "PH_logoutLink")
    private WebElement exitButton;

    // Кнопка "Написать письмо"
    @FindBy (xpath = "//span[text()='Написать письмо']")
    private WebElement writeLetterButton;

    // Входящие
    @FindBy (xpath = "//div[@class='nav__folder-name__txt'][text()='Входящие']")
    private WebElement inbox;

    // Черновики
    @FindBy (xpath = "//div[@class='nav__folder-name__txt'][text()='Черновики']")
    private WebElement drafts;

    // Test
    @FindBy (xpath = "//div[@class='nav__folder-name__txt'][text()='Тест']")
    private WebElement test;

    // Отправленные
    @FindBy (xpath = "//div[@class='nav__folder-name__txt'][text()='Отправленные']")
    private WebElement sent;

    // Корзина
    @FindBy (xpath = "//div[@class='nav__folder-name__txt'][text()='Корзина']")
    private WebElement trash;

    // Всплывающее сообщение при наведении на "Черновики"
    @FindBy (xpath = "//a[@href='/drafts/']")
    private WebElement popupMessageDrafts;

    // Список всех всплывающих сообщений
    @FindBy (xpath = "//div[@class='nav-folders']//a")
    private List<WebElement> foldersList;

    // Кнопка "Очистить содержимое" во всплывающем меню
    @FindBy (xpath = "//span[@class='list-item__text'][text()='Очистить содержимое']")
    private WebElement clearContentsButton;

    // Кнопка "Очистить" в всплывающем окне при удалении
    @FindBy (xpath = "//div[@class='layer__submit-button']//span[@class='button2__txt'][text()='Очистить']")
    private WebElement clearButton;

    // Нажатие на "Выход"
    public void exit(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
    }

    // Нажатие не "Написать письмо"
    public void clickWriteLetterButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(writeLetterButton)).click();
    }

    // Переход в "Черновики"
    public void goToDrafts(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(drafts)).click();
    }

    // Переход во "Входящие"
    public void goToInbox(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inbox)).click();
    }

    // Переход во "Отправленные"
    public void goToSent(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(sent)).click();
    }

    // Переход в "Тест"
    public void goToTest(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(test)).click();
    }

    // Переход в "Корзина"
    public void goToTrash(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(trash)).click();
    }

    // Удаление из всех папок
    public void deleteFromAllFolder(){
        for (WebElement webElement : foldersList) {
            if (!webElement.getAttribute("title").contains("нет писем")) {
                wait = new WebDriverWait(driver, 10);
                Actions action = new Actions(driver);
                action.moveToElement(webElement).contextClick().build().perform();
                action.moveToElement(clearContentsButton).click().build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(clearButton)).click();
            }
        }
    }

    public WebElement getWriteLetterButton() {
        return writeLetterButton;
    }

    public String getPopupMessageDrafts() {
        return popupMessageDrafts.getAttribute("title");
    }
}
