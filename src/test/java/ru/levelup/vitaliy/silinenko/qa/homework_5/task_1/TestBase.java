package ru.levelup.vitaliy.silinenko.qa.homework_5.task_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages.*;
import ru.levelup.vitaliy.silinenko.qa.homework_5.task_1.pages.folders.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;
    protected AuthPage authPage;
    protected HomePage homePage;
    protected CreateLetterPage createPage;
    protected DraftsPage draftsPage;
    protected InboxPage inboxPage;
    protected SentPage sentPage;
    protected TestPage testPage;
    protected TrashPage trashPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        authPage = new AuthPage(driver);
        homePage = new HomePage(driver);
        createPage = new CreateLetterPage(driver);
        draftsPage = new DraftsPage(driver);
        inboxPage = new InboxPage(driver);
        sentPage = new SentPage(driver);
        testPage = new TestPage(driver);
        trashPage = new TrashPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
