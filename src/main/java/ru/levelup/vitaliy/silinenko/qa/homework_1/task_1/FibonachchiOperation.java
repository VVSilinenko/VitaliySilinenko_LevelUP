package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.util.Scanner;

public class FibonachchiOperation {

    void calculate(Scanner in, int digit) {
        if (digit < 0) {
            System.out.print("Необходимо ввести число больше или равно 0");
        } else if (digit == 0 || digit == 1) {
            System.out.print("Результат: " + digit);
        } else {
            long a = 0;
            long b = 1;
            for (int i = 2; i <= digit; ++i) {
                long next = a + b;
                a = b;
                b = next;
            }
            System.out.print("Результат: " + b);
        }
    }
}
