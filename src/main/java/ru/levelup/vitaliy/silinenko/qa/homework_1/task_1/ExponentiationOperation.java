package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ExponentiationOperation {

    private int exponent;

    void calculate(Scanner in, double digit) {
        System.out.print("Введите степень: ");
        exponent = in.nextInt();
        if (exponent == 1) {
            System.out.print("Результат: " + digit);
        } else {
            double num3 = digit;
            while (exponent > 1) {
                num3 = num3 * digit;
                exponent--;
            }
            System.out.print("Результат: " + (new BigDecimal(num3).setScale(2, RoundingMode.UP).doubleValue()));
        }
    }
}
