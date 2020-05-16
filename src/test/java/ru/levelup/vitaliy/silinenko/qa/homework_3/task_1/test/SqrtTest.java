package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SqrtTest extends TestBase{

    @DataProvider(name = "DoubleTest")
    public Object[][] DoubleTest() {
        return new Object[][]{
                {4, 2},
                {169, 13},
                {36.29, 6.024118192731613},
                {0, 0},
                {-25, 5},
                {0.25, 0.5}
        };
    }

    @Test(dataProvider = "DoubleTest")
    public void powDoubleTest(double a, double expectedResult){
        assertEquals(calculator.sqrt(a), expectedResult);
    }
}
