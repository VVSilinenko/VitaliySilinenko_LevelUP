package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
