package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class SubTest extends TestBase {

    @DataProvider(name = "LongTest")
    public Object[][] LongTest() {
        return new Object[][] {
                {523, 52, 471},
                {-45, -36, -9},
                {0, 673, -673},
                {237, -237, 474},
                {235489657, 586948568, -351458911}
        };
    }

    @Test(dataProvider = "LongTest")
    public void subLongTest(long a, long b, long expectedResult){
        assertEquals(calculator.sub(a,b), expectedResult);
    }

    @DataProvider(name = "DoubleTest")
    public Object[][] DoubleTest() {
        return new Object[][]{
                {56.84, 89.2525, -32.4125},
                {-253.4, -89.22458, -164.1754},
                {2.5869, 1.2245, 1.3624},
                {-5.634, -1.433, -4.201},
                {-2.222, -2.222, 0}
        };
    }

    @Test (dataProvider = "DoubleTest")
    public void subDoubleTest(double a, double b, double expectedResult){
        double round = new BigDecimal(calculator.sub(a,b)).setScale(4, RoundingMode.HALF_UP).doubleValue();
        assertEquals(round, expectedResult);
    }
}
