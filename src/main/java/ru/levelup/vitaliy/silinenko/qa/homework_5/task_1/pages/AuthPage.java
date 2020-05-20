package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AuthPage {

    public AuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Поле для ввода логина
    @FindBy (id = "mailbox:login")
    private WebElement loginField;

    // Поле для ввода пароля
    @FindBy (id = "mailbox:password")
    private WebElement passwordField;

    // Кнопка "Ввести пароль"
    @FindBy (css = "input[value='Ввести пароль']")
    private WebElement enterPasswordButton;

    // Кнопка "Войти"
    @FindBy (id = "mailbox:submit")
    private WebElement submitButton;

    // Выпадающий список доменов
    @FindBy (id = "mailbox:domain")
    private WebElement domainButton;

    // Список с доменами
    @FindBy (xpath = "//select[@id='mailbox:domain']/option")
    private List<WebElement> domainsList;

    public void authorization(String login, String password){
        loginField.sendKeys("tester.csi");
        changeDomain("@list.ru");
        enterPasswordButton.click();
        passwordField.sendKeys("WgsXM9JS39kuvAC");
        submitButton.click();
    }

    private void changeDomain(String domainName){
        domainButton.click();
        List<WebElement> domains = domainsList;
        for (WebElement domain : domains) {
            if (domain.getText().equals(domainName)) {
                domain.click();
                break;
            }
        }
        domainButton.click();
    }

}
