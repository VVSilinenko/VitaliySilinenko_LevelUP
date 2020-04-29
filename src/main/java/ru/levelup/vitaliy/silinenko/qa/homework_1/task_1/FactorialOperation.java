package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

import java.util.Scanner;

public class FactorialOperation {

    void calculate(Scanner in, int digit) {
        if (digit < 0) {
            System.out.printf("Необходимо ввести число больше или равно 0");
        } else if (digit == 0 || digit == 1) {
            System.out.printf("Результат: " + digit);
        } else {
            int result = 1;
            for (int i = 1; i <= digit; i++){
                result = result * i;
            }
            System.out.printf("Результат: " + result);
        }

    }
}
