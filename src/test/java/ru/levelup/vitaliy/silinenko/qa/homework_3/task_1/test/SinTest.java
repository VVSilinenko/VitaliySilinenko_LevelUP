package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class SinTest {

    @DataProvider(name = "DoubleTest")
    public static Object[][] DoubleTest() {
        return new Object[][]{
                {0.0, 0.0000},
                {30.0, 0.5000},
                {45.0, 0.7071},
                {60.0, 0.8660},
                {90.0, 1.0000},
                {180.0, 0.0000},
                {270.0, -1.0000},
                {360.0, 0.0000}
        };
    }

    @Test(dataProvider = "DoubleTest")
    public void sinDoubleTest(double a, double expectedResult) {
        Calculator calculator = new Calculator();
        double round = new BigDecimal(calculator.sin(a)).setScale(4, RoundingMode.HALF_UP).doubleValue();
        assertEquals(round, expectedResult);
    }
}
