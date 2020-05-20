package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPage extends BaseFolderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Сообщение, если папка пустая
    @FindBy (xpath = "//div[contains(@class, 'no-drafts')]")
    private WebElement messageWhenDraftsIsEmpty;

    public WebElement getMessageWhenDraftsIsEmpty() {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(messageWhenDraftsIsEmpty));
    }
}
