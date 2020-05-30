package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AuthPage extends BasePage {

    public AuthPage(WebDriver driver) {
        super(driver);
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


    public void authorization(){
        Properties authProperties = new Properties();
        try {
            authProperties.load(this.getClass().getClassLoader().getResourceAsStream("auth.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String login = authProperties.getProperty("login");
        String password = authProperties.getProperty("password");
        String domain = authProperties.getProperty("domain");

        loginField.sendKeys(login);
        changeDomain(domain);
        enterPasswordButton.click();
        passwordField.sendKeys(password);
        submitButton.click();
    }

    private void changeDomain(String domainName){
        Select select = new Select(domainButton);
        select.selectByVisibleText(domainName);
    }

}
