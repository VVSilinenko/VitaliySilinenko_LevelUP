package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.util.Scanner;

public class SubstractionOperation {

    private double num2;

    void calculate(Scanner in, double digit) {
        System.out.print("Введите второе число: ");
        num2 = in.nextInt();
        System.out.printf("Результат: " + (digit - num2));
    }
}
