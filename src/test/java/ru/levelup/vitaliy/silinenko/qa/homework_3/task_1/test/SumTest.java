package ru.levelup.vitaliy.silinenko.qa.homework_3.task_1.test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest {


    @DataProvider(name = "LongTest")
    public static Object[][] LongTest() {
        return new Object[][] {
                {45632, 2342, 47974},
                {4, 4, 8},
                {23, 7, 30},
                {-34, 42, 8},
                {-1, 1, 0}
        };
    }

    @DataProvider(name = "DoubleTest")
    public static Object[][] DoubleTest() {
        return new Object[][]{
                {2.6, 4.3, 6.9},
                {1.8, 3.9, 5.7},
                {0.5, 1.8, 2.3},
                {-5.6, -1.4, -7},
                {0, -1, -1}
        };
    }

    @Test (dataProvider = "LongTest")
    public void sumLongTest(long a, long b, long expectedResult){
        Calculator calculator = new Calculator();
        assertEquals(calculator.sum(a,b), expectedResult);
    }

    @Test (dataProvider = "DoubleTest")
    public void sumDoubleTest(double a, double b, double expectedResult){
        Calculator calculator = new Calculator();
        assertEquals(calculator.sum(a,b), expectedResult);
    }


}
