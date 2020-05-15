package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class TgTest extends TestBase{

    @DataProvider(name = "DoubleTest")
    public Object[][] DoubleTest() {
        return new Object[][]{
                {0.0, 0.0000},
                {30.0, 0.5774},
                {45.0, 1.0000},
                {60.0, 1.7321},
                {90.0, 0.0000},
                {180.0, 0.0000}
        };
    }

    @Test(dataProvider = "DoubleTest")
    public void tgDoubleTest(double a, double expectedResult){
        double round = new BigDecimal(calculator.tg(a)).setScale(4, RoundingMode.HALF_UP).doubleValue();
        assertEquals(round, expectedResult);
    }

}
