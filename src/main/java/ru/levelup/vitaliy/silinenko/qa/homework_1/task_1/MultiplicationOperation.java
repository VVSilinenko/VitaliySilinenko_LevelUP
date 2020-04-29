package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MultiplicationOperation {

    double calculate(double digit1, double digit2) {
        return new BigDecimal(digit1 * digit2).setScale(2, RoundingMode.UP).doubleValue();
    }
}
