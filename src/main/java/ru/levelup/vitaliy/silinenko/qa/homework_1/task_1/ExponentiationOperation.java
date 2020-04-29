package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExponentiationOperation {

    double calculate(double digit1, double digit2) {
        int exponent = (int) digit2;
        System.out.println("Число " + digit1 + " будет возведено в степень " + exponent);
        if (exponent == 1) {
            return digit1;
        } else {
            double result = digit1;
            while (exponent > 1) {
                result *= digit1;
                exponent--;
            }
            return new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        }
    }
}
