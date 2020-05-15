package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }
}
