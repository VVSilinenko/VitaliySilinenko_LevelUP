package ru.levelup.vitaliy.silinenko.qa.homework_1.task_1;

public class FactorialOperation {

    int calculate(double digit1) {
        int digit = (int) digit1;
        if (digit < 0) {
            System.out.println("Введено отрицательное число. Оно будет преобразовано в положительное");
            digit = Math.abs(digit);
        }
        System.out.println("Будет посчитан факториал числа \"" + digit + "\"");
        if (digit == 0 || digit == 1) {
            return digit;
        } else {
            int result = 1;
            for (int i = 1; i <= digit; i++){
                result *= i;
            }
            return result;
        }

    }


}
