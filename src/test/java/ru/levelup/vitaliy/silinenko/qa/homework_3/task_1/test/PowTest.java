package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PowTest extends TestBase{

    @DataProvider(name = "DoubleTest")
    public Object[][] DoubleTest() {
        return new Object[][]{
                {4, 2, 16},
                {-25.3, 1, -25.3},
                {3.554, 4, 159.54003899905598},
                {0, 2, 0},
                {-2.222, -3.5, 0.04102265660144527},
                {-3, 3, -27}
        };
    }

    @Test(dataProvider = "DoubleTest")
    public void powDoubleTest(double a, double b, double expectedResult){
        assertEquals(calculator.pow(a,b), expectedResult);
    }
}
