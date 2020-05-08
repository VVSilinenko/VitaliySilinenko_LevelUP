package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultTest {

    @DataProvider(name = "LongTest")
    public static Object[][] LongTest() {
        return new Object[][] {
                {3, 9, 27},
                {-45, 5, -225},
                {0, 673, 0},
                {-8, -9, 72},
                {54, -3, -162},
                {23569, 2235, 52676715}
        };
    }

    @Test(dataProvider = "LongTest")
    public void multLongTest(long a, long b, long expectedResult){
        Calculator calculator = new Calculator();
        assertEquals(calculator.mult(a,b), expectedResult);
    }

    @DataProvider(name = "DoubleTest")
    public static Object[][] DoubleTest() {
        return new Object[][]{
                {2.44, 2, 4.88},
                {-25.3, 0.3666, -9.27498},
                {3.554, -8.3, -29.4982},
                {0, -1.433, 0},
                {-2.222, -2.222, 4.937284}
        };
    }

    @Test (dataProvider = "DoubleTest")
    public void multDoubleTest(double a, double b, double expectedResult){
        Calculator calculator = new Calculator();
        assertEquals(calculator.mult(a,b), Math.floor(expectedResult));
    }
}
