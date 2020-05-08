package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivTest {

    @DataProvider(name = "LongTest")
    public static Object[][] LongTest() {
        return new Object[][]{
                {3, 1, 3},
                {56, 28, 2},
                {-9, -3, 3},
                {-36, 12, -3},
                {9131328, 36, 253648},
                {0, 6, 0},
                {64, 0, 0}
        };
    }

    @Test(dataProvider = "LongTest")
    public void divLongTest(long a, long b, long expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(calculator.div(a, b), expectedResult);

    }

    @DataProvider(name = "DoubleTest")
    public static Object[][] DoubleTest() {
        return new Object[][]{
                {4.88, 2, 2.44},
                {-25.3, 3.66, -6.912568306010929},
                {3.554, -8.3, -0.4281927710843373},
                {0, -1.433, 0},
                {-2.222, -2.222, 1},
                {3.4562, 0.76, 4.547631578947368}
        };
    }

    @Test(dataProvider = "DoubleTest")
    public void divDoubleTest(double a, double b, double expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(calculator.div(a, b), expectedResult);
    }
}
