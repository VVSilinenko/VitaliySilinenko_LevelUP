package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MultiplicationOperation {

    private double num2;

    void calculate(Scanner in, double digit) {
        System.out.print("Введите второе число: ");
        num2 = in.nextDouble();
        double result = new BigDecimal(digit * num2).setScale(2, RoundingMode.UP).doubleValue();
        System.out.print("Результат: " + result);
    }
}
