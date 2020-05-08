package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class CtgTest {

    @DataProvider(name = "DoubleTest")
    public static Object[][] DoubleTest() {
        return new Object[][]{
                {30.0, 1.7321},
                {45.0, 1.0000},
                {60.0, 0.5774},
                {90.0, 0.0000},
                {270.0, 0.0000}
        };
    }

    @Test(dataProvider = "DoubleTest")
    public void ctgDoubleTest(double a, double expectedResult){
        Calculator calculator = new Calculator();
        double round = new BigDecimal(calculator.ctg(a)).setScale(4, RoundingMode.HALF_UP).doubleValue();
        assertEquals(round, expectedResult);
    }

}
