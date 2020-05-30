package ru.levelup.vitaliy.silinenko.qa.homework_6.task_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps.ActionSteps;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps.AssertionSteps;
import ru.levelup.vitaliy.silinenko.qa.homework_6.task_1.steps.PreparatorySteps;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;
    protected PreparatorySteps preparatorySteps;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
        preparatorySteps = new PreparatorySteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
