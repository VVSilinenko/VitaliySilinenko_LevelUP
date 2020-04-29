package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.util.Scanner;

public class AdditionalOperation {

    private double num2;

    void calculate(Scanner in, double digit) {
        System.out.print("Введите второе число: ");
        num2 = in.nextDouble();
        System.out.print("Результат: " + (digit + num2));
    }
}

